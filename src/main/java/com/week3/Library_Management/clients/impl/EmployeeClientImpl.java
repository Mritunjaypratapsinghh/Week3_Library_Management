package com.week3.Library_Management.clients.impl;

import com.week3.Library_Management.advices.ApiResponse;
import com.week3.Library_Management.clients.EmployeeClient;
import com.week3.Library_Management.dto.EmployeeDTO;
import com.week3.Library_Management.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try {


            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get().
                    uri("employees").retrieve().body(new ParameterizedTypeReference<>() {
            });
            return employeeDTOList.getData() ;

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        try {
            ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient.get().uri("employees/{employeeId}", employeeId).
                    retrieve().body(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {
                    });
            return employeeDTOApiResponse.getData();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        try{
            ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient.post().uri("employees").body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is5xxServerError,(req,res) ->{
                        System.out.println("Error Occured"+res.getBody().readAllBytes());
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res) ->{
                        System.out.println("Error Occured"+res.getBody().readAllBytes());
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {
                    });
            return employeeDTOApiResponse.getData();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
