package com.example.inkspire.character.model;

import com.example.inkspire.common.UserExist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CharacterDto {
    @NotNull(message = "유저 ID는 필수 입력 값입니다.")
    @UserExist
    private Long userId;

    @NotBlank(message = "캐릭터 이름은 필수 입력 값입니다.")
    private String name;

    @NotNull(message = "행운은 필수 입력 값입니다.")
    private Integer luck;

    @NotNull(message = "방어력은 필수 입력 값입니다.")
    private Integer defense;

    @NotNull(message = "정신력은 필수 입력 값입니다.")
    private Integer mental;

    @NotNull(message = "민첩도는 필수 입력 값입니다.")
    private Integer agility;

    @NotNull(message = "공격력은 필수 입력 값입니다.")
    private Integer attack;

    @NotNull(message = "hp는 필수 입력 값입니다.")
    private Integer hp;
}
