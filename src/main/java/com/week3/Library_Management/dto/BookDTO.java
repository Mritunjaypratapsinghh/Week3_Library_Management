package com.week3.Library_Management.dto;

import com.week3.Library_Management.entities.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private String name;
    private AuthorSummaryDTO author;
}
