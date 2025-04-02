package com.week3.Library_Management.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class BookEntity {

    private Long id;
    private String name;
    @ManyToMany
    @JoinColumn(name = "Author Of Book")
    private AuthorEntity author;
}
