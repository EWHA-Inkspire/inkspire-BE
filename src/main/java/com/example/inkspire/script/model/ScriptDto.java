package com.example.inkspire.script.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScriptDto {
    @NotNull(message = "캐릭터 아이디는 필수 입력 값입니다.")
    private Long characterId;
    @NotBlank(message = "시간적 배경은 필수 입력 값입니다.")
    private String time;
    @NotBlank(message = "공간적 배경은 필수 입력 값입니다.")
    private String place;
    @NotBlank(message = "장르는 필수 입력 값입니다.")
    private String genre;
}
