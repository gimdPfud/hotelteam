package com.example.hotelteam.service;

import com.example.hotelteam.dto.BoardDTO;
import com.example.hotelteam.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.security.Principal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Log4j2
class BoardServiceImplTest {
    @Autowired
    BoardService boardService;
    BoardRepository boardRepository;

    @Test
    public void register(){
        for (int i=0; i<50; i++){
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setBoardTitle("제목"+i);
            boardDTO.setBoardContent("내용"+i);
            boardService.register(boardDTO);
        }

    }

}