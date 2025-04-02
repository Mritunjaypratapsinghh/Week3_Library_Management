package com.week3.Library_Management.repositories;

import com.week3.Library_Management.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositories extends JpaRepository<BookEntity,Long> {
}
