package com.example.inkspire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "script_id", nullable = false)
    private Script script;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "common_code_id", nullable = false)
    private CommonCode role;

    @Column(name = "content", nullable = false)
    private String content;
}
