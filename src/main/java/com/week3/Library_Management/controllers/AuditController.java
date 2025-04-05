package com.week3.Library_Management.controllers;


import com.week3.Library_Management.dto.BookDTO;
import com.week3.Library_Management.entities.BookEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/audit")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping(path = "/book/{bookId}")
    List<BookEntity> getBookRevisions(@PathVariable Long bookId){
        AuditReader auditReader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());

        List<Number> revisions = auditReader.getRevisions(BookEntity.class,bookId);
        return revisions.stream().map(revisionNumber-> auditReader.find(BookEntity.class,bookId, revisionNumber))
                .collect(Collectors.toList());
    }
}
