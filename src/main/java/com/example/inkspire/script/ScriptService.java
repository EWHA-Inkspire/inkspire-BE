package com.example.inkspire.script;

import com.example.inkspire.character.model.Character;
import com.example.inkspire.common.CommonCode;
import com.example.inkspire.common.DataResponseDto;
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
    public DataResponseDto<Long> createScript(ScriptDto scriptDto, Long characterId) {
        Script script = new Script();

        // 존재하지 않는 장르일 경우 예외 처리
        if (CommonCode.of(COMMON_CODE, scriptDto.getGenre()).equals(CommonCode.NOT_FOUND)) {
            throw new GeneralException(ErrorCode.GENRE_NOT_FOUND);
        }

        Script.builder().character(Character.builder().id(characterId).build())
                .time(scriptDto.getTime())
                .place(scriptDto.getPlace())
                .genre(CommonCode.of(COMMON_CODE, scriptDto.getGenre()))
                .build();

        Script saved = scriptRepository.save(script);

        return DataResponseDto.of(saved.getId());
    }

    /* npc 정보 저장 */
    public DataResponseDto<Long> createNpc(NpcInfoDto npcInfoDto) {
        Npc npc = new Npc();

        Npc.builder().name(npcInfoDto.getName())
                .map(Map.builder().id(npcInfoDto.getMapId()).build())
                .isPnpc(npcInfoDto.isPnpc())
                .greeting(npcInfoDto.getGreeting())
                .build();

        Npc saved = npcRepository.save(npc);

        return DataResponseDto.of(saved.getId());
    }

    /* 맵 정보 저장 */
    public DataResponseDto<Long> createMap(MapDto mapDto, Long scriptId) {
        Map map = new Map();

        Map.builder().script(Script.builder().id(scriptId).build())
                .name(mapDto.getName())
                .chapter(mapDto.getChapter())
                .eventTrigger(map.getEventTrigger())
                .eventType(mapDto.getEventType())
                .lastVisited(false)
                .build();

        Map saved = mapRepository.save(map);

        return DataResponseDto.of(saved.getId());
    }
}
