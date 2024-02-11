package com.example.inkspire.script;

import com.example.inkspire.common.DataResponseDto;
import com.example.inkspire.script.model.MapDto;
import com.example.inkspire.script.model.NpcInfoDto;
import com.example.inkspire.script.model.ScriptDto;
import jakarta.validation.Valid;
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
    @PostMapping
    public ResponseEntity<DataResponseDto<Long>> createScript(@RequestBody @Valid ScriptDto scriptDto) {
        DataResponseDto<Long> response = scriptService.createScript(scriptDto.getCharacterId(), scriptDto);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    /* npc 정보 저장 */
    @PostMapping("/npc")
    public ResponseEntity<DataResponseDto<Long>> createNpc(@RequestBody @Valid NpcInfoDto npcInfoDto) {
        DataResponseDto<Long> response = scriptService.createNpc(npcInfoDto);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    /* 맵 정보 저장 */
    @PostMapping("/map")
    public ResponseEntity<DataResponseDto<Long>> createCharacter(@RequestBody @Valid MapDto mapDto) {
        DataResponseDto<Long> response = scriptService.createMap(mapDto);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }
}
