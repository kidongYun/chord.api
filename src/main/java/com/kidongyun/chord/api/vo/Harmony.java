package com.kidongyun.chord.api.vo;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public enum Harmony {
    MAJOR(Set.of(4, 7), ""),
    MINOR(Set.of(3, 7), "m"),
    MINOR_SEVEN(Set.of(3, 7, 10), "m7"),
    MINOR_MAJOR_SEVEN(Set.of(3, 7, 11), "mM7"),
    ADD_TWO(Set.of(2, 7), "2"),
    AUGMENT(Set.of(4, 8), "+"),
    DIMINISH(Set.of(3, 6), "dim"),
    DIMINISH_SEVEN(Set.of(3, 6, 9), "dim7"),
    SUSPENDED4(Set.of(5, 7), "sus4"),
    SEVEN(Set.of(4, 7, 10), "7"),
    MAJOR_SEVEN(Set.of(4, 7, 11), "M7"),
    UNKNOWN(Set.of(), "unknown");

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
        } else if(set.size() == 3 && set.containsAll(Set.of(3, 7, 10))) {
            return MINOR_SEVEN;
        } else if(set.size() == 3 && set.containsAll(Set.of(3, 7, 11))) {
            return MINOR_MAJOR_SEVEN;
        } else if(set.size() == 2 && set.containsAll(Set.of(2, 7))) {
            return ADD_TWO;
        } else if(set.size() == 2 && set.containsAll(Set.of(4, 8))) {
            return AUGMENT;
        } else if(set.size() == 2 && set.containsAll(Set.of(3, 6))) {
            return DIMINISH;
        } else if(set.size() == 2 && set.containsAll(Set.of(5, 7))) {
            return SUSPENDED4;
        } else if(set.size() == 3 && set.containsAll(Set.of(4, 7, 10))) {
            return SEVEN;
        } else if(set.size() == 3 && set.containsAll(Set.of(4, 7, 11))) {
            return MAJOR_SEVEN;
        }

        return UNKNOWN;
    }
}
