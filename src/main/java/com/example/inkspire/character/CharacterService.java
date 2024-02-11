package com.example.inkspire.character;

import com.example.inkspire.character.model.ChapterListDto;
import com.example.inkspire.character.model.Character;
import com.example.inkspire.character.model.CharacterDto;
import com.example.inkspire.common.DataResponseDto;
import com.example.inkspire.common.annotation.UserAuthentication;
import com.example.inkspire.user.model.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterService {
    private final CharacterRepository characterRepository;

    /* 캐릭터 별 생성된 챕터 리스트 조회 */
    public DataResponseDto<ChapterListDto> getChapterList(Long id) {
        List<Integer> chapterList = characterRepository.findChapterByCharacterId(id);

        return DataResponseDto.of(new ChapterListDto(chapterList));
    }

    /* 캐릭터 생성 */
    @UserAuthentication
    public DataResponseDto<Long> createCharacter(Long userId, CharacterDto characterDto) {
        Character character = Character.builder()
                .user(User.builder().id(userId).build())
                .name(characterDto.getName())
                .luck(characterDto.getLuck())
                .defense(characterDto.getDefense())
                .mental(characterDto.getMental())
                .agility(characterDto.getAgility())
                .attack(characterDto.getAttack())
                .hp(characterDto.getHp())
                .build();

        Character saved = characterRepository.save(character);

        return DataResponseDto.of(saved.getId());
    }
}
