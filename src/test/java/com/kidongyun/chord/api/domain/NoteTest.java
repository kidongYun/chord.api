package com.kidongyun.chord.api.domain;

import com.kidongyun.chord.api.vo.Key;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteTest {
    @Test
    public void of_whenC1ValueIsOffered_thenReturnCKeyAnd1Octave() {
        /* Arrange */
        String stub = "C1";

        /* Act */
        Note result = Note.of(stub);

        /* Assert */
        assert result != null;
        assertThat(result.getKey()).isEqualTo(Key.DO);
        assertThat(result.getOctave()).isEqualTo(1);
    }

    @Test
    public void of_whenFSharp2ValueIsOffered_thenReturnCSharpKeyAnd2Octave() {
        /* Arrange */
        String stub = "F#2";

        /* Act */
        Note result = Note.of(stub);

        /* Assert */
        assert result != null;
        assertThat(result.getKey()).isEqualTo(Key.FA_SHARP);
        assertThat(result.getOctave()).isEqualTo(2);
    }

    @Test
    public void of_whenCCValueIsOffered_thenReturnNull_bcsOctaveShouldBeDigit() {
        /* Arrange */
        String stub = "CC";

        /* Act */
        Note result = Note.of(stub);

        /* Assert */
        assertThat(result).isNull();
    }
}