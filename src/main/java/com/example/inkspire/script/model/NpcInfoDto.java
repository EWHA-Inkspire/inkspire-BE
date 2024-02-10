package com.example.inkspire.script.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NpcInfoDto {
    private String name;
    private String greeting;
    private boolean isPnpc;
    private Long mapId;
}
