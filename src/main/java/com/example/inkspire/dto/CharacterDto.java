package com.example.inkspire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CharacterDto {
    private Long memberId;
    private String name;
    private Integer luck;
    private Integer defense;
    private Integer mental;
    private Integer agility;
    private Integer attack;
    private Integer hp;
}
