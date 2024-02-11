package com.example.inkspire.script;

import com.example.inkspire.character.CharacterRepository;
import com.example.inkspire.character.model.Character;
import com.example.inkspire.common.CommonCode;
import com.example.inkspire.common.DataResponseDto;
import com.example.inkspire.common.annotation.CharacterAuthentication;
import com.example.inkspire.common.errors.ErrorCode;
import com.example.inkspire.common.errors.GeneralException;
import com.example.inkspire.script.model.Map;
import com.example.inkspire.script.model.MapDto;
import com.example.inkspire.script.model.Npc;
import com.example.inkspire.script.model.NpcInfoDto;
import com.example.inkspire.script.model.Script;
import com.example.inkspire.script.model.ScriptDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScriptService {
    private final ScriptRepository scriptRepository;
    private final NpcRepository npcRepository;
    private final MapRepository mapRepository;
    private final String COMMON_CODE = "GENRE";

    /* 스크립트 정보 저장 */
    @CharacterAuthentication
    public DataResponseDto<Long> createScript(Long characterId, ScriptDto scriptDto) {

        // 존재하지 않는 장르일 경우 예외 처리
        if (CommonCode.of(COMMON_CODE, scriptDto.getGenre()).equals(CommonCode.NOT_FOUND)) {
            throw new GeneralException(ErrorCode.GENRE_NOT_FOUND);
        }

        Script script = Script.builder()
                .character(Character.builder().id(characterId).build())
                .time(scriptDto.getTime())
                .place(scriptDto.getPlace())
                .genre(CommonCode.of(COMMON_CODE, scriptDto.getGenre()))
                .build();

        Script saved = scriptRepository.save(script);

        return DataResponseDto.of(saved.getId());
    }

    /* npc 정보 저장 */
    public DataResponseDto<Long> createNpc(NpcInfoDto npcInfoDto) {
        Map map = mapRepository.findById(npcInfoDto.getMapId())
                .orElseThrow(() -> new GeneralException(ErrorCode.MAP_NOT_FOUND));

        Npc npc = Npc.builder().name(npcInfoDto.getName())
                .map(map)
                .isPnpc(npcInfoDto.isPnpc())
                .greeting(npcInfoDto.getGreeting())
                .build();

        Npc saved = npcRepository.save(npc);

        return DataResponseDto.of(saved.getId());
    }

    /* 맵 정보 저장 */
    public DataResponseDto<Long> createMap(MapDto mapDto) {
        Script script = scriptRepository.findById(mapDto.getScriptId())
                .orElseThrow(() -> new GeneralException(ErrorCode.SCRIPT_NOT_FOUND));

        Map map = Map.builder()
                .script(script)
                .name(mapDto.getName())
                .chapter(mapDto.getChapter())
                .eventTrigger(mapDto.getEventTrigger())
                .eventType(mapDto.getEventType())
                .lastVisited(false)
                .build();

        Map saved = mapRepository.save(map);

        return DataResponseDto.of(saved.getId());
    }
}
