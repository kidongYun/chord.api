package com.kidongyun.chord.api.vo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class KeyTest {
    @Test
    public void of_whenKeysAreOffered_thenReturnResultsMatchedEachOther() {
        /* Arrange, Act, Assert */
        assertThat(Key.of("C").getCode()).isEqualTo(Key.DO.getCode());
        assertThat(Key.of("C#").getCode()).isEqualTo(Key.DO_SHARP.getCode());
        assertThat(Key.of("D").getCode()).isEqualTo(Key.RE.getCode());
        assertThat(Key.of("D#").getCode()).isEqualTo(Key.RE_SHARP.getCode());
        assertThat(Key.of("E").getCode()).isEqualTo(Key.MI.getCode());
        assertThat(Key.of("F").getCode()).isEqualTo(Key.FA.getCode());
        assertThat(Key.of("F#").getCode()).isEqualTo(Key.FA_SHARP.getCode());
        assertThat(Key.of("G").getCode()).isEqualTo(Key.SOL.getCode());
        assertThat(Key.of("G#").getCode()).isEqualTo(Key.SOL_SHARP.getCode());
        assertThat(Key.of("A").getCode()).isEqualTo(Key.LA.getCode());
        assertThat(Key.of("A#").getCode()).isEqualTo(Key.LA_SHARP.getCode());
        assertThat(Key.of("B").getCode()).isEqualTo(Key.SI.getCode());
    }
}