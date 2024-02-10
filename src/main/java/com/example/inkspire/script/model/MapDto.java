package com.example.inkspire.script.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MapDto {
    private String name;
    private Integer chapter;
    private String eventTrigger;
    private String eventType;
}
