package com.example.inkspire.service;

import com.example.inkspire.dto.CharacterInfoDto;
import com.example.inkspire.dto.CharacterListDto;
import com.example.inkspire.dto.DataResponseDto;
import com.example.inkspire.entity.Characters;
import com.example.inkspire.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    /* 캐릭터 리스트 조회 */
    public DataResponseDto<CharacterListDto> getCharacterList(Long id) {
        Optional<Characters> characterList = characterRepository.findAllByMemberId(id);

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
}
