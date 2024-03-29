package com.example.inkspire.gpt.model;

import com.example.inkspire.common.CommonCode;
import com.example.inkspire.script.model.Script;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "script_id", nullable = false)
    private Script script;

    @Column(name = "role", nullable = false)
    private CommonCode role;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "chapter", nullable = false)
    private Integer chapter;

    @Column(name = "summary", nullable = false)
    private String summary;
}
