package com.kidongyun.chord.api.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Key {
    DO("C", "도"),
    DO_SHARP("C#", "도샾"),
    RE("D", "레"),
    RE_SHARP("D#", "레샾"),
    MI("E", "미"),
    FA("F", "파"),
    FA_SHARP("F#", "파샾"),
    SOL("G", "솔"),
    SOL_SHARP("G#", "솔샾"),
    LA("A", "라"),
    LA_SHARP("A#", "라샾"),
    SI("B", "시"),
    UNKNOWN("UNKNOWN", "알수없음");

    Key(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private final String code;
    private final String name;

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
