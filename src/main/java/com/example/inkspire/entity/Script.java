package com.example.inkspire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Script {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "character_id", nullable = false)
    private Characters characters;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "place", nullable = false)
    private String place;

    // TODO: common_code 테이블로 관리할 사항 많아질 경우 수정하기
    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "universe")
    private String universe;

    @Column(name = "ending", nullable = false)
    private boolean ending;
}
