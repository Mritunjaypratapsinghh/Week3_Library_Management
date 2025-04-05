package com.week3.Library_Management.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;

    private String email;

    private Integer age;

    private String role; //ADMIN,USER

    private Double salary;

    private LocalDate dateOfJoining;

    private String password;

    private Boolean isActive;

}

