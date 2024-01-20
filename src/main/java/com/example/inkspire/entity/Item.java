package com.example.inkspire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "map_id", nullable = false)
    private Map map;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "common_code_id", nullable = false)
    private CommonCode type;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "detail")
    private String detail;
}
