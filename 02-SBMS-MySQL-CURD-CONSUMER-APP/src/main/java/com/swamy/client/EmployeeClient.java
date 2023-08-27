package com.swamy.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.swamy.dto.EmployeeDto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EmployeeClient {

	private RestTemplate restTemplate;

	private static final String URL = "http://localhost:8081/api/employees";

	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		return restTemplate.postForEntity(URL, employeeDto, EmployeeDto.class).getBody();
	}

	public List<EmployeeDto> getAllEmployees() {
		EmployeeDto[] employees = restTemplate.getForEntity(URL, EmployeeDto[].class).getBody();
		return Arrays.asList(employees);
	}

	public EmployeeDto getEmployeeById(Integer employeeId) {
		return restTemplate.getForEntity(URL + "/" + employeeId, EmployeeDto.class).getBody();
	}

	public EmployeeDto updateEmployee(Integer employeeId, EmployeeDto employeeDto) {

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<EmployeeDto> request = new HttpEntity<>(employeeDto, headers);

		return restTemplate.exchange(URL + "/" + employeeId, HttpMethod.PUT, request, EmployeeDto.class).getBody();

	}

	public String deleteEmployee(Integer employeeId) {
		return restTemplate.exchange(URL + "/" + employeeId, HttpMethod.DELETE, null, String.class).getBody();
	}
}
