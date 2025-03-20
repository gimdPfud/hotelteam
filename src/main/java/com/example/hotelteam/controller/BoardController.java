package com.example.hotelteam.controller;

import com.example.hotelteam.dto.BoardDTO;
import com.example.hotelteam.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/register")
    public String registerGet(BoardDTO boardDTO){
        return "board/register";
    }
    @PostMapping
    public String register(BoardDTO boardDTO){
        boardService.register(boardDTO);
        return "redirect:list";
    }
}

