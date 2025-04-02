package com.week3.Library_Management.controllers;


import com.week3.Library_Management.dto.BookDTO;
import com.week3.Library_Management.services.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

}

