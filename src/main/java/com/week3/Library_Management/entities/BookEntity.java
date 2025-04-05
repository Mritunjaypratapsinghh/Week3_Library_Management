package com.week3.Library_Management.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Audited
public class BookEntity extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "Author Of Book")
    @JsonBackReference
    private AuthorEntity author;

    @PrePersist
    void beforeSave(){
        System.out.println("before Save is called");
    }

    @PreUpdate
    void beforeUpdate(){
        System.out.println("beforeUpdate is called");
    }


    @PreRemove
    void beforeRemove(){
        System.out.println("before Remove is called");
    }
}
