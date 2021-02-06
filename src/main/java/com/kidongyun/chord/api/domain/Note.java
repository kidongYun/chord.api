package com.kidongyun.chord.api.domain;

import com.kidongyun.chord.api.vo.Key;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
@Getter
@Setter
@ToString
@Builder
public class Note {
    private Key key;
    private Integer octave;

    public static Note of(String note) {
        if(!StringUtils.hasLength(note) || note.length() < 2) {
            return null;
        }

        if(!Character.isDigit(note.charAt(note.length() - 1))) {
            return null;
        }

        String key = note.substring(0, note.length() - 1);
        String octave = note.charAt(note.length() - 1) + "";

        return Note.builder().key(Key.of(key)).octave(Integer.parseInt(octave)).build();
    }
}
