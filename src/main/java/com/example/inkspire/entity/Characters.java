package com.example.inkspire.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Characters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "luck", nullable = false)
    private Integer luck;

    @Column(name = "defense", nullable = false)
    private Integer defense;

    @Column(name = "mental", nullable = false)
    private Integer mental;

    @Column(name = "agility", nullable = false)
    private Integer agility;

    @Column(name = "attack", nullable = false)
    private Integer attack;

    @Column(name = "hp", nullable = false)
    private Integer hp;

    @Column(name = "success")
    private String success;

    @Column(name = "fail")
    private String fail;
}
