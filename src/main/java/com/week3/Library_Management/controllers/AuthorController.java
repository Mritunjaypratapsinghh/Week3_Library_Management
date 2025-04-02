package com.week3.Library_Management.controllers;

import com.week3.Library_Management.dto.AuthorDTO;
import com.week3.Library_Management.services.AuthorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }


    @GetMapping(path = "/{authorId}")
    public AuthorDTO getAuthorById(@PathVariable Long authorId){
        return authorService.getAuthorById(authorId);
    }

    @PostMapping
    public AuthorDTO createNewAuthor(@RequestBody AuthorDTO request){
        return authorService.createNewAuthor(request);
    }


}
