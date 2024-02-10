package com.example.inkspire.character.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterInfoDto {
    private Long id;
    private String name;
    private String success;
    private String fail;
}
