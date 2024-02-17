package com.example.inkspire.script.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScriptDto {
    @NotBlank(message = "시간적 배경은 필수 입력 값입니다.")
    private String time;
    @NotBlank(message = "공간적 배경은 필수 입력 값입니다.")
    private String place;
    @NotBlank(message = "장르는 필수 입력 값입니다.")
    private String genre;
}
