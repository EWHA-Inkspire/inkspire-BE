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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "common_code_id", nullable = false)
    private CommonCode type;

    @Column(name = "chapter", nullable = false)
    private Integer chapter;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "required", nullable = false)
    private String required;

    @Column(name = "etc", nullable = false)
    private String etc;

    @Column(name = "achieved", nullable = false)
    private boolean achieved;
}
