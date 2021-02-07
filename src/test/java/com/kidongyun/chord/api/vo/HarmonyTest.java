package com.kidongyun.chord.api.vo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class HarmonyTest {
    @Test
    public void of_when_then() {
        /* Arrange, Act, Assert */
        assertThat(Harmony.of(Set.of(4, 7))).isEqualTo(Harmony.MAJOR);
        assertThat(Harmony.of(Set.of(3, 7))).isEqualTo(Harmony.MINOR);
    }
}