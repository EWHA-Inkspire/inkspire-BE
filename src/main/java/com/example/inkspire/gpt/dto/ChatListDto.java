package com.example.inkspire.gpt.dto;

import com.example.inkspire.common.CommonCode;
import com.example.inkspire.gpt.model.Chat;
import com.example.inkspire.script.model.Script;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatListDto {
    private ArrayList<ChatDto> chats;

    @Getter
    @AllArgsConstructor
    public static class ChatDto {
        @NotNull(message = "스크립트 아이디는 필수 입력 값입니다.")
        private Long scriptId;
        @NotBlank(message = "role은 필수 입력 값입니다.")
        private String role;
        @NotBlank(message = "내용은 필수 입력 값입니다.")
        private String content;
        @NotNull(message = "챕터는 필수 입력 값입니다.")
        private Integer chapter;
        private String summary;

        public Chat toEntity() {
            return Chat.builder()
                    .script(Script.builder().id(scriptId).build())
                    .role(CommonCode.of("ROLE", role))
                    .content(content)
                    .chapter(chapter)
                    .summary(summary)
                    .build();
        }
    }
}
