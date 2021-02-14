package com.kidongyun.chord.api.domain;

import com.kidongyun.chord.api.vo.Key;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Slf4j
@Getter
@ToString
public class Note {
    public static final Integer OCTAVE_SIZE = 12;

    private final Key key;
    private final Integer octave;
    private Integer pitch;

    @Builder(buildMethodName = "buildInternal")
    private Note(Key key, Integer octave) {
        this.key = key;
        this.octave = octave;
    }

    private static void postBuild(Note note) {
        if(Objects.isNull(note.key) || Objects.isNull(note.octave)) {
            return;
        }

        note.pitch = note.key.getPitch() + ((note.octave - 1) * OCTAVE_SIZE);
    }

    public static class NoteBuilder {
        public Note build() {
            Note note = this.buildInternal();
            postBuild(note);
            return note;
        }
    }

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

    public static Note empty() {
        return Note.builder().build();
    }
}
