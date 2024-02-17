package com.example.inkspire.script.dto;

import com.example.inkspire.character.model.Character;
import com.example.inkspire.common.CommonCode;
import com.example.inkspire.script.model.Script;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterAndScriptDto {
    private CharacterDto character;
    private ScriptDto script;

    @Getter
    public static class CharacterDto {
        private Long id;
        private String name;
        private Integer luck;
        private Integer defense;
        private Integer mental;
        private Integer agility;
        private Integer attack;
        private Integer hp;

        public CharacterDto(Character character) {
            this.id = character.getId();
            this.name = character.getName();
            this.luck = character.getLuck();
            this.defense = character.getDefense();
            this.mental = character.getMental();
            this.agility = character.getAgility();
            this.attack = character.getAttack();
            this.hp = character.getHp();
        }
    }

    @Getter
    public static class ScriptDto {
        private Long id;
        private String time;
        private String place;
        private CommonCode genre;
        private String universe;

        public ScriptDto(Script script) {
            this.id = script.getId();
            this.time = script.getTime();
            this.place = script.getPlace();
            this.genre = script.getGenre();
            this.universe = script.getUniverse();
        }
    }
}
