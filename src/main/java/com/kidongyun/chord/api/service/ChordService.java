package com.kidongyun.chord.api.service;

import com.kidongyun.chord.api.domain.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class ChordService {
    /** 입력된 음들 중에 근음을 찾아서 반환 */
    public Optional<Note> findBase(List<Note> notes) {
        if(Objects.isNull(notes) || notes.isEmpty()) {
            return Optional.empty();
        }

        return notes.stream().min(Comparator.comparingInt(Note::getPitch));
    }

    /** 같은 옥타브 내에서 두 음정의 차이를 계산 */
    public Integer diffInOctave(Integer base, Integer target) {
        Integer basePosition = base % Note.OCTAVE_SIZE;
        Integer targetPosition = target % Note.OCTAVE_SIZE;

        return Math.abs(basePosition - targetPosition);
    }
}
