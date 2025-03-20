package com.example.hotelteam.service;

import com.example.hotelteam.dto.BoardDTO;
import com.example.hotelteam.entity.Board;
import com.example.hotelteam.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void register(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);
        board = boardRepository.save(board);
        boardDTO = modelMapper.map(board, BoardDTO.class);


    }

    @Override
    public Page<BoardDTO> list(Pageable pageable) {
        Page<Board> pageList = boardRepository.findAll(pageable);
        return null;
    }

    @Override
    public BoardDTO read(Long boardNum) {

        Optional<Board> optionalBoard = boardRepository.findById(boardNum);
        Board board = optionalBoard.get();
        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);
        return boardDTO;
    }

    @Override
    public BoardDTO update(BoardDTO boardDTO) {
        return null;
    }

    @Override
    public Long del(Long boardNum) {
        return 0L;
    }
}
