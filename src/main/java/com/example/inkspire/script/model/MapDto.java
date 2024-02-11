package com.example.inkspire.script.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MapDto {
    @NotNull(message = "스크립트 아이디는 필수 입력 값입니다.")
    private Long scriptId;
    @NotBlank(message = "장소 이름은 필수 입력 값입니다.")
    private String name;
    @NotNull(message = "등장 챕터 번호는 필수 입력 값입니다.")
    private Integer chapter;
    private String eventTrigger;
    private String eventType;
}
