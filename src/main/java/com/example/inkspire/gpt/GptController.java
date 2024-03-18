package com.example.inkspire.gpt;

import com.example.inkspire.common.response.Response;
import com.example.inkspire.gpt.dto.ChatListDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class GptController {
    private final GptService gptService;

    /* 플레이 내용 기록 */
    @PostMapping
    public ResponseEntity<Response> createChatList(@Valid @RequestBody ChatListDto chatListDto) {
        gptService.createChatList(chatListDto);

        return Response.of(HttpStatus.CREATED);
    }
}
