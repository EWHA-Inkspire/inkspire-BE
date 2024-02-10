package com.example.inkspire.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private String eventTrigger;

    @Column(name = "eventy_type")
    private String eventType;

    @Column(name = "last_visited", nullable = false)
    private boolean lastVisited;
}
