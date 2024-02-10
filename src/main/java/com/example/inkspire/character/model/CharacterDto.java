package com.example.inkspire.character.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CharacterDto {
    private Long userId;
    private String name;
    private Integer luck;
    private Integer defense;
    private Integer mental;
    private Integer agility;
    private Integer attack;
    private Integer hp;
}
