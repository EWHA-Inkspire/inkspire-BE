package com.example.inkspire.character;

import com.example.inkspire.character.model.ChapterListDto;
import com.example.inkspire.character.model.Character;
import com.example.inkspire.character.model.CharacterDto;
import com.example.inkspire.character.model.CharacterInfoDto;
import com.example.inkspire.character.model.CharacterListDto;
import com.example.inkspire.common.DataResponseDto;
import com.example.inkspire.user.model.User;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterService {
    private final CharacterRepository characterRepository;

    /* 캐릭터 리스트 조회 */
    public DataResponseDto<CharacterListDto> getCharacterList(Long id) {
        Optional<Character> characterList = characterRepository.findAllByUserId(id);

        if (characterList.isPresent()) {
            List<CharacterInfoDto> results = characterList.stream()
                    .map(character -> new CharacterInfoDto(
                            character.getId(),
                            character.getName(),
                            character.getSuccess(),
                            character.getFail()))
                    .collect(Collectors.toList());

            return DataResponseDto.of(new CharacterListDto(results));
        } else {
            // 캐릭터 리스트가 없을 경우에 대한 예외 처리 -> 빈 리스트를 반환
            return DataResponseDto.of(new CharacterListDto());
        }
    }

    /* 캐릭터 별 생성된 챕터 리스트 조회 */
    public DataResponseDto<ChapterListDto> getChapterList(Long id) {
        List<Integer> chapterList = characterRepository.findChapterByCharacterId(id);

        return DataResponseDto.of(new ChapterListDto(chapterList));
    }

    /* 캐릭터 생성 */
    public DataResponseDto<Long> createCharacter(CharacterDto characterDto) {
        Character character = new Character();

        Character.builder().user(User.builder().id(characterDto.getUserId()).build())
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
