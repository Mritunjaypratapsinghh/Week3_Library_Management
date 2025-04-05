package com.week3.Library_Management.clients.impl;

import com.week3.Library_Management.advices.ApiResponse;
import com.week3.Library_Management.clients.EmployeeClient;
import com.week3.Library_Management.dto.EmployeeDTO;
import com.week3.Library_Management.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        log.trace("Trying to retrieve all employees in getAllEmployees");
        try {
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get().
                    uri("employees").
                    retrieve().
                    onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("employees not found");

                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.debug("Successfully retrieved the employees in getAllEmployees");
            log.trace("Retrieved Employees list in getAllEmployees: {},{},{}", employeeDTOList.getData(), "hello", 5);
            return employeeDTOList.getData();

        } catch (Exception e) {
            log.error("Exception occured in getAllEmployees", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        log.trace("trying to get Employee by Id in getEmployeeById with id: {}", employeeId);
        try {
            ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient.get().uri("employees/{employeeId}", employeeId).
                    retrieve().
                    onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Not able to find the employee with id: "+employeeId);
                    }).
                    body(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {
                    });
            return employeeDTOApiResponse.getData();

        } catch (Exception e) {
            log.error("Exception Occurred in getEmployeeById",e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        log.trace("trying to create Employee with information: {}", employeeDTO);
        try {
            ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient.post().uri("employees").body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {
                    });
            log.trace("Successfully created a new employee : {}", employeeDTOApiResponse);
            return employeeDTOApiResponse.getData();
        } catch (Exception e) {
            log.error("Exception Occurred in createNewEmployee",e);
            throw new RuntimeException(e);
        }
    }


}
