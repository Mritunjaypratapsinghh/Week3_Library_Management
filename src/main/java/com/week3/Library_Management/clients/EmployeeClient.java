package com.week3.Library_Management.clients;

import com.week3.Library_Management.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO  employeeDTO);
}
