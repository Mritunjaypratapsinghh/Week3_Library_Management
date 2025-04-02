package com.week3.Library_Management.services;

import com.week3.Library_Management.dto.BookDTO;
import com.week3.Library_Management.entities.AuthorEntity;
import com.week3.Library_Management.entities.BookEntity;
import com.week3.Library_Management.repositories.AuthorRepository;
import com.week3.Library_Management.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;


@Service
public class BookService {

    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final AuthorRepository authorRepository;

    public BookService(ModelMapper modelMapper, BookRepository bookRepository,AuthorRepository authorRepository, AuthorService authorService){
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }


    public void exitsBookById(Long bookId){
        boolean exists = bookRepository.existsById(bookId);
        if(!exists) throw new RuntimeException("Book does not exist with Id: "+ bookId);
    }

    public BookDTO getBookById(Long bookId) {
        exitsBookById(bookId);
        BookEntity bookEntity = bookRepository.findById(bookId).get();
        return modelMapper.map(bookEntity,BookDTO.class);
    }

    public BookDTO createNewBook(BookDTO request){
        BookEntity bookEntity = modelMapper.map(request,BookEntity.class);
        BookEntity newBook = bookRepository.save(bookEntity);
        return modelMapper.map(newBook,BookDTO.class);
    }


    public BookDTO assignAuthorToBook(Long bookId, Long authorId) {
        exitsBookById(bookId);
        authorService.existAuthorById(authorId);
        BookEntity bookEntity = bookRepository.findById(bookId).get();
        AuthorEntity authorEntity = authorRepository.findById(authorId).get();
        bookEntity.setAuthor(authorEntity);
        if (authorEntity.getBooks() == null) {
            authorEntity.setBooks(new ArrayList<>());
        }
        if(authorEntity.getBooks().contains(bookEntity)){
        authorEntity.getBooks().add(bookEntity);}
        BookEntity bookEntity1 = bookRepository.save(bookEntity);
        return modelMapper.map(bookEntity1, BookDTO.class);
    }

}
