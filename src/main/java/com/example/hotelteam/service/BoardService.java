package com.example.hotelteam.service;

import com.example.hotelteam.dto.BoardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    public void register(BoardDTO boardDTO);
    public Page<BoardDTO>list(Pageable pageable);
    public BoardDTO read(Long boardNum);
    public BoardDTO update(BoardDTO boardDTO);
    public Long del(Long boardNum);
}
