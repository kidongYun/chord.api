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
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
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
        List<Note> stubs = Stream.<Note>builder().build().collect(toList());

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
    public void findBase_when_then() {
        /* Arrange */
        List<Note> stubs = Stream.<Note>builder()
                .add(Note.builder().key(Key.DO).octave(1).build())
                .add(Note.builder().key(Key.MI).octave(1).build())
                .add(Note.builder().key(Key.SOL).octave(1).build())
                .build().collect(toList());

        log.info("YKD : " + stubs);

        /* Act */
        Note result = chordService.findBase(stubs).orElse(Note.empty());

        /* Assert */
        assertThat(result.getKey().getCode()).isEqualTo(Key.DO.getCode());
        assertThat(result.getKey().getName()).isEqualTo(Key.DO.getName());
        assertThat(result.getKey().getPitch()).isEqualTo(Key.DO.getPitch());
    }
}