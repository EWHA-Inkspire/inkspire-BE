package com.example.inkspire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "script_id", nullable = false)
    private Script script;

    @Column(name = "chapter", nullable = false)
    private Integer chapter;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "required", nullable = false)
    private String required;

    // TODO: common_code 테이블로 관리할 사항 많아질 경우 수정하기
    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "etc", nullable = false)
    private String etc;

    @Column(name = "achieved", nullable = false)
    private boolean achieved;
}
