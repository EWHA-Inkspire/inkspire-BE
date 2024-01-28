package com.example.inkspire.controller;

import com.example.inkspire.dto.ChapterListDto;
import com.example.inkspire.dto.CharacterListDto;
import com.example.inkspire.dto.DataResponseDto;
import com.example.inkspire.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/character")
public class CharacterController {
    private final CharacterService characterService;

    /* 캐릭터 리스트 조회 */
    @GetMapping("/characterList")
    public ResponseEntity<DataResponseDto<CharacterListDto>> getCharacterList(@Validated @RequestParam Long id) {
        return new ResponseEntity<>(characterService.getCharacterList(id), HttpStatus.OK);
    }

    /* 생성된 챕터 리스트 조회 */
    @GetMapping("/chapterList")
    public ResponseEntity<DataResponseDto<ChapterListDto>> getChapterList(@Validated @RequestParam Long id) {
        return new ResponseEntity<>(characterService.getChapterList(id), HttpStatus.OK);
    }
}
