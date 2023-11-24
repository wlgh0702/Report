package com.domaji.practice.board.controller;

import com.domaji.practice.board.dto.BoardAndNameDTO;
import com.domaji.practice.board.dto.BoardDTO;
import com.domaji.practice.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시판
    @GetMapping("board")
    public String board(Model model) {

        List<BoardAndNameDTO> board = boardService.getBoardList();

        model.addAttribute("boardList", board);

        return "board";
    }

    // 글쓰기 버튼 눌렀을 때 가는 페이지
    @GetMapping("/boardWrite")
    public String boardWrite() {
        return "boardWrite";
    }

    // 글 쓰고 눌렀을 때
    @PostMapping("/boardWrite")
    public String boardWrite(String title, String content, int memberNo) {

        Map<String, Object> board = new HashMap<>();
        System.out.println(board);

        board.put("title", title);
        board.put("content", content);
        board.put("memberNo", memberNo);

        int result = boardService.insertBoard(board);

        System.out.println(memberNo);
        return "redirect:/board";
    }

    // 게시글 상세보기
    @GetMapping("/board/{code}")
    public String boardContent(@PathVariable int code, Model model) {

        BoardAndNameDTO board = boardService.getBoard(code);

        model.addAttribute("board", board);

        return "boardContent";
    }
}
