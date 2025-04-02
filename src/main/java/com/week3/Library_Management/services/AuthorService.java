package com.week3.Library_Management.services;

import com.week3.Library_Management.dto.AuthorDTO;
import com.week3.Library_Management.entities.AuthorEntity;
import com.week3.Library_Management.repositories.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    public AuthorService(AuthorRepository authorRepository, ModelMapper modelMapper){
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    public void existAuthorById(Long authorId){
        boolean exists = authorRepository.existsById(authorId);
        if(!exists) throw new RuntimeException("Author with id does not exist: "+authorId);
    }


    public AuthorDTO getAuthorById(Long authorId) {
        existAuthorById(authorId);
        AuthorEntity authorEntity= authorRepository.findById(authorId).get();
        return modelMapper.map(authorEntity, AuthorDTO.class);
    }

    public AuthorDTO createNewAuthor(AuthorDTO request) {
        AuthorEntity authorEntity= modelMapper.map(request, AuthorEntity.class);
        AuthorEntity author = authorRepository.save(authorEntity);
        return modelMapper.map(author,AuthorDTO.class);
    }
}
