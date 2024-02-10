package com.example.inkspire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NpcInfoDto {
    private String name;
    private String greeting;
    private boolean isPnpc;
    private Long mapId;
}
