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

    @GetMapping(path = "/{bookId}")
    public BookDTO getBookById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }

    @PostMapping
    public BookDTO createNewBook(@RequestBody BookDTO request){
        return bookService.createNewBook(request);
    }

    @PatchMapping(path = "/{bookId}/author/{authorId}")
    public BookDTO assignAuthorToBook(@PathVariable Long bookId, @PathVariable Long authorId){
        return bookService.assignAuthorToBook(bookId,authorId);
    }

}

