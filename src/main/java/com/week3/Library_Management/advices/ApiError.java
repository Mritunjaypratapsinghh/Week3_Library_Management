package com.week3.Library_Management.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Data
@Builder
public class ApiError {
    private HttpStatus httpStatus;
    private String message;
    private List<String> suberror;

}
