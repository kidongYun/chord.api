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
        /* Arrange */
        String cKeyStub = "C";
        String cSharpKeyStub = "C#";
        String dKeyStub = "D";
        String dSharpKeyStub = "D#";
        String eKeyStub = "E";
        String fKeyStub = "F";
        String fSharpKeyStub = "F#";
        String gKeyStub = "G";
        String gSharpKeyStub = "G#";
        String aKeyStub = "A";
        String aSharpKeyStub = "A#";
        String bKeyStub = "B";

        /* Act, Assert */
        assertThat(Key.of(cKeyStub).getCode()).isEqualTo(Key.DO.getCode());
        assertThat(Key.of(cSharpKeyStub).getCode()).isEqualTo(Key.DO_SHARP.getCode());
        assertThat(Key.of(dKeyStub).getCode()).isEqualTo(Key.RE.getCode());
        assertThat(Key.of(dSharpKeyStub).getCode()).isEqualTo(Key.RE_SHARP.getCode());
        assertThat(Key.of(eKeyStub).getCode()).isEqualTo(Key.MI.getCode());
        assertThat(Key.of(fKeyStub).getCode()).isEqualTo(Key.FA.getCode());
        assertThat(Key.of(fSharpKeyStub).getCode()).isEqualTo(Key.FA_SHARP.getCode());
        assertThat(Key.of(gKeyStub).getCode()).isEqualTo(Key.SOL.getCode());
        assertThat(Key.of(gSharpKeyStub).getCode()).isEqualTo(Key.SOL_SHARP.getCode());
        assertThat(Key.of(aKeyStub).getCode()).isEqualTo(Key.LA.getCode());
        assertThat(Key.of(aSharpKeyStub).getCode()).isEqualTo(Key.LA_SHARP.getCode());
        assertThat(Key.of(bKeyStub).getCode()).isEqualTo(Key.SI.getCode());
    }
}