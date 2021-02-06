package com.kidongyun.chord.api.service;

import com.kidongyun.chord.api.domain.Note;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ChordService {

    public Optional<Note> findBase(List<Note> notes) {
        if(Objects.isNull(notes) || notes.isEmpty()) {
            return Optional.empty();
        }

        return Optional.empty();
    }
}
