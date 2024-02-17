package com.example.inkspire.script;

import com.example.inkspire.character.CharacterService;
import com.example.inkspire.character.model.Character;
import com.example.inkspire.character.model.CharacterDto;
import com.example.inkspire.common.response.Response;
import com.example.inkspire.script.dto.CharacterAndScriptDto;
import com.example.inkspire.script.dto.GoalDto;
import com.example.inkspire.script.dto.ItemDto;
import com.example.inkspire.script.dto.MapDto;
import com.example.inkspire.script.dto.NpcInfoDto;
import com.example.inkspire.script.dto.ScenarioDto;
import com.example.inkspire.script.dto.ScriptDto;
import com.example.inkspire.script.model.Goal;
import com.example.inkspire.script.model.Item;
import com.example.inkspire.script.model.Map;
import com.example.inkspire.script.model.Npc;
import com.example.inkspire.script.model.Script;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scripts")
public class ScriptController {

    private final ScriptService scriptService;
    private final CharacterService characterService;

    /* 스크립트 정보 저장 */
    @PostMapping
    public ResponseEntity<Response> createScript(@RequestBody @Valid ScenarioDto scenarioDto) {
        CharacterDto characterDto = scenarioDto.getCharacter();
        Character character = characterService.createCharacter(characterDto.getUserId(), characterDto);

        ScriptDto scriptDto = scenarioDto.getScript();
        Script script = scriptService.createScript(character.getId(), scriptDto);

        CharacterAndScriptDto result = CharacterAndScriptDto.builder()
                .character(new CharacterAndScriptDto.CharacterDto(character))
                .script(new CharacterAndScriptDto.ScriptDto(script)).build();

        return Response.of(HttpStatus.CREATED, result);
    }

    /* npc 정보 저장 */
    @PostMapping("/npc")
    public ResponseEntity<Response> createNpc(@RequestBody @Valid NpcInfoDto npcInfoDto) {
        Npc createdNpc = scriptService.createNpc(npcInfoDto);

        return Response.of(HttpStatus.CREATED, createdNpc);
    }

    /* 맵 정보 저장 */
    @PostMapping("/map")
    public ResponseEntity<Response> createCharacter(@RequestBody @Valid MapDto mapDto) {
        Map createdMap = scriptService.createMap(mapDto);

        return Response.of(HttpStatus.CREATED, createdMap);
    }

    /* 목표 정보 저장 */
    @PostMapping("/goal")
    public ResponseEntity<Response> createGoal(@RequestBody @Valid GoalDto goalDto) {
        Goal createdGoal = scriptService.createGoal(goalDto);

        return Response.of(HttpStatus.CREATED, createdGoal);
    }

    /* 아이템 정보 저장 */
    @PostMapping("/item")
    public ResponseEntity<Response> createItem(@RequestBody @Valid ItemDto itemDto) {
        Item createdItem = scriptService.createItem(itemDto);

        return Response.of(HttpStatus.CREATED, createdItem);
    }
}
