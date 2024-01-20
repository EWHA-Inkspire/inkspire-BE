package com.example.inkspire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Npc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "map_id", nullable = false)
    private Map map;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "greeting")
    private String greeting;

    @Column(name = "is_pnpc", nullable = false)
    private boolean is_pnpc;
}
