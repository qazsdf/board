package com.board.service;

import com.board.domain.entity.BoardEntity;
import com.board.domain.repository.BoardRepository;
import com.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Transactional
    public List<BoardDto> getBoardlist(){
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (BoardEntity boardEntity : boardEntities){
            BoardDto boardDTO = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .writer(boardEntity.getWriter())
                    .content(boardEntity.getContent())
                    .createdDate(boardEntity.getCreatedDate())
                    .build();

            boardDtoList.add(boardDTO);
        }
        return boardDtoList;
    }

    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional
    public BoardDto getPost(Long id){
        Optional<BoardEntity> boardEntityWrapper = boardRepository.findById(id);
        BoardEntity boardEntity = boardEntityWrapper.get();

        BoardDto boardDTO = BoardDto.builder()
                .id(boardEntity.getId())
                .writer(boardEntity.getWriter())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .createdDate(boardEntity.getCreatedDate())
                .build();

        return boardDTO;
    }

    @Transactional
    public void deletePost(Long id){
        boardRepository.deleteById(id);
    }

}
