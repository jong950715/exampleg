package com.example.exampleg.model;


import com.example.exampleg.controller.BoardForm;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter(value = AccessLevel.PRIVATE)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    public Board formToBoard(BoardForm boardform){
        this.setTitle(boardform.getTitle());
        this.setContent(boardform.getContent());

        return this;
    }
}