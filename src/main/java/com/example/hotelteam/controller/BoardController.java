package com.example.hotelteam.controller;

import com.example.hotelteam.dto.BoardDTO;
import com.example.hotelteam.service.BoardService;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.security.Security;

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
    @PostMapping("/register")
    public String register(BoardDTO boardDTO){

        log.info("boardDTO 받은거 " + boardDTO);
        boardService.register(boardDTO);
        return "redirect:list";
    }
    @GetMapping("/list")
    public String list(Model model,@PageableDefault(size = 10, page = 0, sort = "boardNum", direction = Sort.Direction.ASC)  Pageable pageable){
//        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        Page<BoardDTO> boardDTOList = boardService.boardlist(pageable);
        model.addAttribute("boardDTOList", boardDTOList);
        return "board/list";
    }
    @GetMapping("/read/{boardNum}")
    public String read(@PathVariable("boardNum")Long boardNum, Model model){
        BoardDTO boardDTO = boardService.read(boardNum);
        model.addAttribute("boardDTO" , boardDTO);
        return "/board/read";
    }
    @GetMapping("/update/{boardNum}")
    public String update(@PathVariable(name = "boardNum")Long boardNum,Model model){
        log.info("수정" + boardNum);
        BoardDTO boardDTO = boardService.read(boardNum);
        model.addAttribute("boardDTO",boardDTO);
        return "board/update";
    }
    @PostMapping("/update/{boardNum}")
    public String updatePost(BoardDTO boardDTO,@PathVariable(name = "boardNum")Long boardNum){
        boardService.register(boardDTO);
        return "board/update";
    }
    @GetMapping("/del/{boardNum}")
    public String del (BoardDTO boardDTO){
        log.info("삭제  : " +boardDTO);
        boardService.del(boardDTO.getBoardNum());
        return "redirect:/board/list";//
    }

}

