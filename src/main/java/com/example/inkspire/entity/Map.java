package com.example.inkspire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "script_id", nullable = false)
    private Script script;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "chapter", nullable = false)
    private Integer chapter;

    @Column(name = "event_trigger")
    private String event_trigger;

    @Column(name = "eventy_type")
    private String event_type;

    @Column(name = "last_visited", nullable = false)
    private boolean last_visited;
}
