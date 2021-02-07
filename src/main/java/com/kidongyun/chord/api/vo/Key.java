package com.kidongyun.chord.api.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Key {
    DO("C", "도", 1),
    DO_SHARP("C#", "도샾", 2),
    RE("D", "레", 3),
    RE_SHARP("D#", "레샾", 4),
    MI("E", "미", 5),
    FA("F", "파", 6),
    FA_SHARP("F#", "파샾", 7),
    SOL("G", "솔", 8),
    SOL_SHARP("G#", "솔샾", 9),
    LA("A", "라", 10),
    LA_SHARP("A#", "라샾", 11),
    SI("B", "시", 12),
    UNKNOWN("UNKNOWN", "알수없음", 0);

    Key(String code, String name, Integer pitch) {
        this.code = code;
        this.name = name;
        this.pitch = pitch;
    }

    private final String code;
    private final String name;
    private final Integer pitch;

    public static Key of(String key) {
        if("C".equals(key)) {
            return DO;
        } else if("C#".equals(key)) {
            return DO_SHARP;
        } else if("D".equals(key)) {
            return RE;
        } else if("D#".equals(key)) {
            return RE_SHARP;
        } else if("E".equals(key)) {
            return MI;
        } else if("F".equals(key)) {
            return FA;
        } else if("F#".equals(key)) {
            return FA_SHARP;
        } else if("G".equals(key)) {
            return SOL;
        } else if("G#".equals(key)) {
            return SOL_SHARP;
        } else if("A".equals(key)) {
            return LA;
        } else if("A#".equals(key)) {
            return LA_SHARP;
        } else if("B".equals(key)) {
            return SI;
        }

        return UNKNOWN;
    }
}
