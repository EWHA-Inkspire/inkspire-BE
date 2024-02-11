package com.example.inkspire.script;

import com.example.inkspire.character.model.Character;
import com.example.inkspire.common.CommonCode;
import com.example.inkspire.common.DataResponseDto;
import com.example.inkspire.common.annotation.CharacterAuthentication;
import com.example.inkspire.common.errors.ErrorCode;
import com.example.inkspire.common.errors.GeneralException;
import com.example.inkspire.script.model.Goal;
import com.example.inkspire.script.model.GoalDto;
import com.example.inkspire.script.model.Item;
import com.example.inkspire.script.model.ItemDto;
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
    private final GoalRepository goalRepository;
    private final ItemRepository itemRepositorye;

    private final String COMMON_CODE_GENRE = "GENRE";
    private final String COMMON_CODE_GOAL = "GOAL";
    private final String COMMON_CODE_ITEM = "ITEM";

    /* 스크립트 정보 저장 */
    @CharacterAuthentication
    public DataResponseDto<Long> createScript(Long characterId, ScriptDto scriptDto) {

        // 존재하지 않는 장르일 경우 예외 처리
        if (CommonCode.of(COMMON_CODE_GENRE, scriptDto.getGenre()).equals(CommonCode.NOT_FOUND)) {
            throw new GeneralException(ErrorCode.GENRE_NOT_FOUND);
        }

        Script script = Script.builder()
                .character(Character.builder().id(characterId).build())
                .time(scriptDto.getTime())
                .place(scriptDto.getPlace())
                .genre(CommonCode.of(COMMON_CODE_GENRE, scriptDto.getGenre()))
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

    /* 목표 정보 저장 */
    public DataResponseDto<Long> createGoal(GoalDto goalDto) {
        Script script = scriptRepository.findById(goalDto.getScriptId())
                .orElseThrow(() -> new GeneralException(ErrorCode.SCRIPT_NOT_FOUND));

        // 존재하지 않는 목표 타입일 경우 예외 처리
        if (CommonCode.of(COMMON_CODE_GOAL, goalDto.getType()).equals(CommonCode.NOT_FOUND)) {
            throw new GeneralException(ErrorCode.GOAL_NOT_FOUND);
        }

        Goal goal = Goal.builder()
                .script(script)
                .chapter(goalDto.getChapter())
                .content(goalDto.getContent())
                .type(CommonCode.of(COMMON_CODE_GOAL, goalDto.getType()))
                .required(goalDto.getContent())
                .etc(goalDto.getEtc())
                .build();

        Goal saved = goalRepository.save(goal);

        return DataResponseDto.of(saved.getId());
    }

    /* 아이템 정보 저장 */
    public DataResponseDto<Long> createItem(ItemDto itemDto) {
        Map map = mapRepository.findById(itemDto.getMapId())
                .orElseThrow(() -> new GeneralException(ErrorCode.MAP_NOT_FOUND));

        // 존재하지 않는 아이템 타입일 경우 예외 처리
        if (CommonCode.of(COMMON_CODE_ITEM, itemDto.getType()).equals(CommonCode.NOT_FOUND)) {
            throw new GeneralException(ErrorCode.ITEM_TYPE_NOT_FOUND);
        }

        Item item = Item.builder()
                .map(map)
                .name(itemDto.getName())
                .detail(itemDto.getDetail())
                .type(CommonCode.of(COMMON_CODE_ITEM, itemDto.getType())).build();

        Item saved = itemRepositorye.save(item);

        return DataResponseDto.of(saved.getId());
    }
}
