package com.example.inkspire.character;

import com.example.inkspire.character.model.ChapterListDto;
import com.example.inkspire.character.model.CharacterDto;
import com.example.inkspire.character.model.CharacterListDto;
import com.example.inkspire.common.DataResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/character")
public class CharacterController {
    private final CharacterService characterService;

    /* 캐릭터 리스트 조회 */
    @GetMapping("/characterList/{userId}")
    public ResponseEntity<DataResponseDto<CharacterListDto>> getCharacterList(@Valid @PathVariable Long userId) {
        DataResponseDto<CharacterListDto> response = characterService.getCharacterList(userId);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    /* 생성된 챕터 리스트 조회 */
    @GetMapping("/chapterList/{characterId}")
    public ResponseEntity<DataResponseDto<ChapterListDto>> getChapterList(@Valid @PathVariable Long characterId) {
        DataResponseDto<ChapterListDto> response = characterService.getChapterList(characterId);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    /* 캐릭터 정보 저장 */
    @PostMapping("/create")
    public ResponseEntity<DataResponseDto<Long>> createCharacter(@RequestBody @Valid CharacterDto characterDto) {
        DataResponseDto<Long> response = characterService.createCharacter(characterDto);
        return new ResponseEntity<>(characterService.createCharacter(characterDto), HttpStatus.valueOf(response.getCode()));
    }
}