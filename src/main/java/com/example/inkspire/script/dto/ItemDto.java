package com.example.inkspire.script.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemDto {

    @NotNull(message = "맵 아이디는 필수 입력 값입니다.")
    private Long mapId;

    @NotBlank(message = "아이템 이름은 필수 입력 값입니다.")
    private String name;

    private String detail;

    @NotBlank(message = "아이탬 유형은 필수 입력 값입니다.")
    private String type;

}
