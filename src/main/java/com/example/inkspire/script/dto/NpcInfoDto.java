package com.example.inkspire.script.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NpcInfoDto {
    @NotBlank(message = "npc 이름은 필수 입력 값입니다.")
    private String name;

    private String greeting;

    @NotNull(message = "pnpc 여부는 필수 입력 값입니다.")
    private boolean isPnpc;

    @NotNull(message = "맵 아이디는 필수 입력 값입니다.")
    private Long mapId;
}
