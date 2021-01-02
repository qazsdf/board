package com.board.domain.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board")
public class BoardEntity extends TimeEntity {

    @Id
    @GeneratedValue

    private Long id;

    @Column
    private String writer;

    @Column
    private String title;

    @Column
    private  String content;

    @Builder
    public BoardEntity(Long id, String writer, String title, String content){
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}
