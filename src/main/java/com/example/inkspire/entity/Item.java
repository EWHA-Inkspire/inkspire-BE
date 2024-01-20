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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "detail")
    private String detail;

    // TODO: common_code 테이블로 관리할 사항 많아질 경우 수정하기
    @Column(name = "type", nullable = false)
    private String type;
}
