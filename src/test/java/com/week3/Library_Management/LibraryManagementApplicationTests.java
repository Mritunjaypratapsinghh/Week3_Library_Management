package com.week3.Library_Management;

import com.week3.Library_Management.clients.EmployeeClient;
import com.week3.Library_Management.dto.EmployeeDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LibraryManagementApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;


	@Test
	@Order(1)
	void getEmployeeByIdTest(){
		EmployeeDTO employeeDTO = employeeClient.getEmployeeById(100L);
		System.out.println(employeeDTO+"response");
	}

	@Test
	@Order(2)
	void createNewEmployeeTest(){
		EmployeeDTO employeeDTO  = new EmployeeDTO(null,"Mritunjay","mritunj@gmail.com",18,"USER",5000.0,
				LocalDate.of(2024,12,12),"password",true);
		EmployeeDTO employeeDTO1 = employeeClient.createNewEmployee(employeeDTO);
		System.out.println(employeeDTO1);
	}


	@Test
	@Order(3)
	void getAllEmployeesTest() {
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

}
