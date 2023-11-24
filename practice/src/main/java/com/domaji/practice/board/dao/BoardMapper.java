package com.domaji.practice.board.dao;

import com.domaji.practice.board.dto.BoardAndNameDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    int insertBoard(Map<String, Object> board);

    List<BoardAndNameDTO> getBoardList();

    BoardAndNameDTO getBoard(int code);
}
