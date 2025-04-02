package com.week3.Library_Management.repositories;

import com.week3.Library_Management.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long>{
}
