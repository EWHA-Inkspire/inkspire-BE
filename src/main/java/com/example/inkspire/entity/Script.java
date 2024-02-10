package com.example.inkspire.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Script {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "character_id", nullable = false)
    private Characters character;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "place", nullable = false)
    private String place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "common_code_id", nullable = false)
    private CommonCode genre;

    @Column(name = "universe")
    private String universe;

    @Column(name = "ending", nullable = false)
    private boolean ending;
}
