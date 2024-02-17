package com.example.inkspire.character;

import com.example.inkspire.character.model.ChapterListDto;
import com.example.inkspire.common.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;

    /* 생성된 챕터 리스트 조회 */
    @GetMapping("{characterId}/chapterList")
    public ResponseEntity<Response> getChapterList(@PathVariable Long characterId) {
        ChapterListDto chapterList = characterService.getChapterList(characterId);
        return Response.of(HttpStatus.OK, chapterList);
    }

}
