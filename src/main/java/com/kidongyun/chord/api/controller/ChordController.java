package com.kidongyun.chord.api.controller;

import com.kidongyun.chord.api.domain.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@RestController
@RequestMapping("api/v1/chord")
public class ChordController {
    @GetMapping
    public ResponseEntity<?> getChord(String notes) {
        /* String -> Note */
        List<Note> noteList = Arrays.stream(notes.trim().replaceAll(" ", "").split(","))
                .map(Note::of).collect(toList());

        log.info("YKD : " + noteList);

        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.getReasonPhrase());
    }
}
