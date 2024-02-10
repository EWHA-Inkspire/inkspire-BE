package com.example.inkspire.script;

import com.example.inkspire.common.DataResponseDto;
import com.example.inkspire.script.model.MapDto;
import com.example.inkspire.script.model.NpcInfoDto;
import com.example.inkspire.script.model.ScriptDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scripts")
public class ScriptController {
    private final ScriptService scriptService;

    /* 스크립트 정보 저장 */
    @PostMapping("/{characterId}")
    public ResponseEntity<DataResponseDto<Long>> createScript(@RequestBody ScriptDto scriptDto, @PathVariable Long characterId) {
        DataResponseDto<Long> response = scriptService.createScript(scriptDto, characterId);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    /* npc 정보 저장 */
    @PostMapping("/{scriptId}/npc")
    public ResponseEntity<DataResponseDto<Long>> createNpc(@RequestBody NpcInfoDto npcInfoDto, @PathVariable Long scriptId) {
        DataResponseDto<Long> response = scriptService.createNpc(npcInfoDto);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    /* 맵 정보 저장 */
    @PostMapping("/{scriptId}/map")
    public ResponseEntity<DataResponseDto<Long>> createCharacter(@RequestBody MapDto mapDto, @PathVariable Long scriptId) {
        DataResponseDto<Long> response = scriptService.createMap(mapDto, scriptId);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }
}
