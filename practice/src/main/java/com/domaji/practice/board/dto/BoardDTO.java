package com.domaji.practice.board.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDTO {

    private int boardNo;
    private String title;
    private String content;
    private Date regDate;
    private int memberNo;
}
