package com.board.dto;


import com.board.domain.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BoardEntity toEntity(){
        BoardEntity build = BoardEntity.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return build;
    }

    @Builder

    public BoardDto(Long id, String writer, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
