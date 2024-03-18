package com.example.inkspire.gpt;

import com.example.inkspire.common.errors.ErrorCode;
import com.example.inkspire.common.errors.GeneralException;
import com.example.inkspire.gpt.dto.ChatListDto;
import com.example.inkspire.gpt.model.Chat;
import com.example.inkspire.script.ScriptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GptService {
    private final ChatRepository chatRepository;
    private final ScriptRepository scriptRepository;

    /* 플레이 기록 저장 */
    public void createChatList(ChatListDto chatListDto) {
        List<Chat> chatList = chatListDto.getChats().stream()
                .map(chatDto -> {
                    // 스크립트 ID에 해당하는 정보가 없을 경우 예외 처리
                    if (!scriptRepository.existsById(chatDto.getScriptId())) {
                        throw new GeneralException(ErrorCode.SCRIPT_NOT_FOUND);
                    }

                    // 존재하는 경우에는 Chat 엔티티로 변환
                    return chatDto.toEntity();
                })
                .collect(Collectors.toList());

        chatRepository.saveAll(chatList);
    }
}
