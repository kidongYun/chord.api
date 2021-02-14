package com.kidongyun.chord.api.dto;

import com.kidongyun.chord.api.domain.Note;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Builder
public class GetChordResponse {
    String chord;
    @Builder.Default
    List<Note> notes = new ArrayList<>();

    public static GetChordResponse of(String chord, List<Note> notes) {
        return GetChordResponse.builder().chord(chord).notes(notes).build();
    }
}
