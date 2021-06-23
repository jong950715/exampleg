package com.example.exampleg.controller;

import com.example.exampleg.model.Board;
import com.example.exampleg.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/list";

    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("boardForm", new BoardForm());
        return "board/form";
    }

    @PostMapping("/form")
    public String formPosting(@ModelAttribute BoardForm boardForm){
        boardRepository.save(boardForm.formToBoard());

        return "redirect:/board/list";
    }

    @GetMapping("/form/{id}")
    public String editForm(@PathVariable("id") Long id, Model model){
        Board board = boardRepository.findById(id).get();
        model.addAttribute("boardForm",BoardForm.boardToForm(board));

        System.out.print("editForm의 board = ");
        System.out.println(board);

        return "board/form";
    }

    @PostMapping("/form/{id}")
    public String editFormSubmit(@PathVariable("id") Long id, @ModelAttribute BoardForm boardForm){
        Board board = boardRepository.findById(id).get();
        boardForm.formToBoard(board);
        //boardRepository.flush();
        System.out.print("editFormSubmit의 board = ");
        System.out.println(board);
        return "redirect:/board/list";
    }


}
