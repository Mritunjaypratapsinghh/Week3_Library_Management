package com.week3.Library_Management.entities;

import jakarta.persistence.*;

@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "Author Of Book")
    private AuthorEntity author;
}
