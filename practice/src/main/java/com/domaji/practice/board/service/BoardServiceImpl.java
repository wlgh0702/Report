package com.domaji.practice.board.service;

import com.domaji.practice.board.dao.BoardMapper;
import com.domaji.practice.board.dto.BoardAndNameDTO;
import com.domaji.practice.board.dto.BoardDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    @Transactional
    public int insertBoard(Map<String, Object> board) {

        int result = boardMapper.insertBoard(board);

        return result;
    }

    @Override
    public List<BoardAndNameDTO> getBoardList() {

        List<BoardAndNameDTO> board = boardMapper.getBoardList();

        return board;
    }

    @Override
    public BoardAndNameDTO getBoard(int code) {

        BoardAndNameDTO board = boardMapper.getBoard(code);

        return board;
    }
}
