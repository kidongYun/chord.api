package com.kidongyun.chord.api.vo;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public enum Harmony {
    MAJOR(Set.of(4, 7), ""),
    MINOR(Set.of(3, 7), "m"),
    UNKNOWN(Set.of(), "UNKNOWN");

    Harmony(Set<Integer> distances, String mark) {
        this.distances = distances;
        this.mark = mark;
    }

    private final Set<Integer> distances;
    private final String mark;

    public static Harmony of(Set<Integer> set) {
        if(set.size() == 2 && set.containsAll(Set.of(4, 7))) {
            return MAJOR;
        } else if(set.size() == 2 && set.containsAll(Set.of(3, 7))) {
            return MINOR;
        }

        return UNKNOWN;
    }
}
