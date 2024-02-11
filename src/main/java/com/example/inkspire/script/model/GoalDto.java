package com.example.inkspire.script.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GoalDto {
    @NotNull(message = "스크립트 아이디는 필수 입력 값입니다.")
    private Long scriptId;

    @Min(value = 1)
    @Max(value = 5)
    @NotNull(message = "챕터 정보는 필수 입력 값입니다.")
    private Integer chapter;

    @NotBlank(message = "목표 정보는 필수 입력 값입니다.")
    private String content;

    @NotBlank(message = "목표 정보는 필수 입력 값입니다.")
    private String type;

    @NotBlank(message = "목표 달성 조건은 필수 입력 값입니다.")
    private String require;

    private String etc;

}
