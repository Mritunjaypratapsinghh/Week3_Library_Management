package com.week3.Library_Management.services;

import com.week3.Library_Management.dto.BookDTO;
import com.week3.Library_Management.entities.BookEntity;
import com.week3.Library_Management.repositories.BookRepositories;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
@Service
public class BookService {

    private final ModelMapper modelMapper;
    private final BookRepositories bookRepositories;

    public BookService(ModelMapper modelMapper, BookRepositories bookRepositories){
        this.modelMapper = modelMapper;
        this.bookRepositories = bookRepositories;
    }


    public void exitsBookById(Long bookId){
        boolean exists = bookRepositories.existsById(bookId);
        if(!exists) throw new RuntimeException("Book does not exist with Id: "+ bookId);
    }

    public BookDTO getBookById(Long bookId) {
        exitsBookById(bookId);
        BookEntity bookEntity = bookRepositories.findById(bookId).get();
        return modelMapper.map(bookEntity,BookDTO.class);
    }

    public BookDTO createNewBook(BookDTO request){
        BookEntity bookEntity = modelMapper.map(request,BookEntity.class);
        BookEntity newBook = bookRepositories.save(bookEntity);
        return modelMapper.map(newBook,BookDTO.class);
    }




}
