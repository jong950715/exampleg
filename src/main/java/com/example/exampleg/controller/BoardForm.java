package com.example.exampleg.controller;

import com.example.exampleg.model.Board;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardForm {

    private Long id;
    private String title;
    private String content;

    public Board formToBoard(){
        Board board = new Board();
        board.formToBoard(this);
        return board;
    }

    public Board formToBoard(Board board){
        board.formToBoard(this);
        return board;
    }

    static public BoardForm boardToForm(Board board){
        BoardForm boardForm = new BoardForm();

        boardForm.setTitle(board.getTitle());
        boardForm.setContent(board.getContent());

        return boardForm;
    }
}
