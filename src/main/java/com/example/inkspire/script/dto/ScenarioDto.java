package com.example.inkspire.script.dto;

import com.example.inkspire.character.model.CharacterDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScenarioDto {
    @NotNull(message = "캐릭터 정보가 누락되었습니다.")
    private CharacterDto character;
    @NotNull(message = "스크립트 정보가 누락되었습니다.")
    private ScriptDto script;
}
