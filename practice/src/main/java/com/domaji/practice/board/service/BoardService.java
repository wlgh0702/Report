package com.domaji.practice.board.service;

import com.domaji.practice.board.dto.BoardAndNameDTO;

import java.util.List;
import java.util.Map;

public interface BoardService {
    int insertBoard(Map<String, Object> board);

    List<BoardAndNameDTO> getBoardList();

    BoardAndNameDTO getBoard(int code);
}
