package com.kidongyun.chord.api.controller;

import com.kidongyun.chord.api.domain.Note;
import com.kidongyun.chord.api.dto.GetChordResponse;
import com.kidongyun.chord.api.service.ChordService;
import com.kidongyun.chord.api.vo.Harmony;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Slf4j
@RestController
@RequestMapping("api/v1/chord")
public class ChordController {
    @Autowired
    ChordService chordService;

    @GetMapping
    public ResponseEntity<?> getChord(String notes) {
        /* String -> Note */
        List<Note> noteList = Arrays.stream(notes.trim().replaceAll(" ", "").split(","))
                .map(Note::of).collect(toList());

        /* 근음을 찾는다 */
        Note base = chordService.findBase(noteList)
                .orElseThrow(() -> new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "근음을 찾지 못했습니다."));

        /* 근음 기준으로 각 음의 간격 계산 */
        Set<Integer> diffs = noteList.stream()
                .filter(note -> !note.getPitch().equals(base.getPitch()))
                .map(note -> chordService.diffInOctave(base.getPitch(), note.getPitch()))
                .collect(toSet());

        return ResponseEntity.status(HttpStatus.OK).body(
                GetChordResponse.of(base.getKey().getCode() + Harmony.of(diffs).getMark(), noteList));
    }
}
