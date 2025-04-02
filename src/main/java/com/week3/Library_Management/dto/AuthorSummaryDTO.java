package com.week3.Library_Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthorSummaryDTO {
    private Long id;
    private String name;
}