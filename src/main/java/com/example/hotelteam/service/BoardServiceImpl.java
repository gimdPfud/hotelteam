package com.example.hotelteam.service;

import com.example.hotelteam.dto.BoardDTO;
import com.example.hotelteam.entity.Board;
import com.example.hotelteam.repository.BoardRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
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
    public Page<BoardDTO> boardlist(Pageable pageable) {
        Page<Board> pageList = boardRepository.findAll(pageable);
        return pageList.map(pl -> modelMapper.map(pl, BoardDTO.class));

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
        Optional<Board> optionalBoard = boardRepository.findById(boardDTO.getBoardNum());

        Board board = optionalBoard.get();
        board.setBoardTitle(boardDTO.getBoardTitle());
        board.setBoardContent(boardDTO.getBoardContent());
        boardDTO = modelMapper.map(board, BoardDTO.class);
        return boardDTO;
    }

    @Override
    public Long del(Long boardNum) {
        boardRepository.deleteById(boardNum);
        return boardNum;
    }
}
