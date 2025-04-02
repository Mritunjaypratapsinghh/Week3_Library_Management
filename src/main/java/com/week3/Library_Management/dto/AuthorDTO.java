package com.week3.Library_Management.dto;

import com.week3.Library_Management.entities.BookEntity;

import java.util.Set;

public class AuthorDTO {

    private Long id;
    private String name;
    private Set<BookDTO> books;
}
