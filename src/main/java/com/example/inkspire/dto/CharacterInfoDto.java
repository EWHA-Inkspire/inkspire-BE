package com.example.inkspire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterInfoDto {
    private Long id;
    private String name;
    private String success;
    private String fail;
}
