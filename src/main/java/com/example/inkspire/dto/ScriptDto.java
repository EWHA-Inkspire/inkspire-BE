package com.example.inkspire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScriptDto {
    private Long characterId;
    private String time;
    private String place;
    private Long genreId;
}
