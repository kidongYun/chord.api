package com.kidongyun.chord.api.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Key {
    DO("C", "도", 0),
    DO_SHARP("C#", "도샾", 1),
    RE("D", "레", 2),
    RE_SHARP("D#", "레샾", 3),
    MI("E", "미", 4),
    FA("F", "파", 5),
    FA_SHARP("F#", "파샾", 6),
    SOL("G", "솔", 7),
    SOL_SHARP("G#", "솔샾", 8),
    LA("A", "라", 9),
    LA_SHARP("A#", "라샾", 10),
    SI("B", "시", 11),
    UNKNOWN("UNKNOWN", "알수없음", -1);

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
