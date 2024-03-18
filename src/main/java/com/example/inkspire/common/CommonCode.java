package com.example.inkspire.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonCode {
    RECOVER("ITEM", "RECOVER"),
    WEAPON("ITEM", "WEAPON"),
    MOB("ITEM", "MOB"),

    ITEM("GOAL", "ITEM"),
    REPORT("GOAL", "REPORT"),
    MONSTER("GOAL", "MONSTER"),

    SYSTEM("ROLE", "SYSTEM"),
    ASSISTANT("ROLE", "ASSISTANT"),
    USER("ROLE", "USER"),

    SF("GENRE", "SF"),
    HORROR("GENRE", "호러"),
    MYSTERY("GENRE", "추리"),

    NOT_FOUND("ERROR","not found");

    private final String category;
    private final String description;

    public static CommonCode of(String category, String description) {
        for (CommonCode c : values()) {
            if (c.category.equals(category) && c.description.equals(description)) {
                return c;
            }
        }
        return NOT_FOUND;
    }
}
