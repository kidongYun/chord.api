package com.kidongyun.chord.api.service;

import com.kidongyun.chord.api.domain.Note;
import com.kidongyun.chord.api.vo.Key;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChordServiceTest {
    @Autowired
    ChordService chordService;

    @Test
    public void findBase_whenEmptyListIsOffered_thenReturnNull() {
        /* Arrange */
        List<Note> stubs = List.of();

        /* Act */
        Note result = chordService.findBase(stubs).orElse(null);

        /* Assert */
        assertThat(result).isNull();
    }

    @Test
    public void findBase_whenNullisOffered_thenReturnNull() {
        /* Arrange, Act */
        Note result = chordService.findBase(null).orElse(null);

        /* Assert */
        assertThat(result).isNull();
    }

    @Test
    public void findBase_whenC1E1G1AreOffered_thenReturnC1() {
        /* Arrange */
        List<Note> stubs = List.of(
                Note.builder().key(Key.DO).octave(1).build(),
                Note.builder().key(Key.MI).octave(1).build(),
                Note.builder().key(Key.SOL).octave(1).build()
        );

        /* Act */
        Note result = chordService.findBase(stubs).orElse(Note.empty());

        /* Assert */
        assertThat(result.getKey().getCode()).isEqualTo(Key.DO.getCode());
        assertThat(result.getKey().getName()).isEqualTo(Key.DO.getName());
        assertThat(result.getKey().getPitch()).isEqualTo(Key.DO.getPitch());
    }

    @Test
    public void findBase_whenE2C3G1AreOffered_thenReturnG1() {
        /* Arrange */
        List<Note> stubs = List.of(
                Note.builder().key(Key.MI).octave(2).build(),
                Note.builder().key(Key.DO).octave(3).build(),
                Note.builder().key(Key.SOL).octave(1).build()
        );

        /* Act */
        Note result = chordService.findBase(stubs).orElse(Note.empty());

        /* Assert */
        assertThat(result.getKey().getCode()).isEqualTo(Key.SOL.getCode());
        assertThat(result.getKey().getName()).isEqualTo(Key.SOL.getName());
        assertThat(result.getKey().getPitch()).isEqualTo(Key.SOL.getPitch());
    }

    @Test
    public void distanceInOctave_whenC1AndE1AreOffered_thenReturn4() {
        /* Arrange */
        Note note1 = Note.of("C1");
        Note note2 = Note.of("E1");

        /* Act */
        assert note1 != null;
        assert note2 != null;
        Integer result = chordService.diffInOctave(note1.getPitch(), note2.getPitch());

        /* Assert */
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void distanceInOctave_whenC2AndB4AreOffered_thenReturn() {
        /* Arrange */
        Note note1 = Note.of("C2");
        Note note2 = Note.of("B4");

        /* Act */
        assert note1 != null;
        assert note2 != null;
        Integer result = chordService.diffInOctave(note1.getPitch(), note2.getPitch());

        /* Assert */
        assertThat(result).isEqualTo(11);
    }

    @Test
    public void distanceInOctave_when_then() {
        /* Arrange */
        Note note1 = Note.of("D1");
        Note note2 = Note.of("C2");

        /* Act */
        assert note1 != null;
        assert note2 != null;
        Integer result = chordService.diffInOctave(note1.getPitch(), note2.getPitch());

        /* Assert */
        assertThat(result).isEqualTo(10);
    }
}