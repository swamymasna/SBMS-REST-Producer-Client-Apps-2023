package com.swamy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.dto.EmployeeDto;
import com.swamy.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@PostMapping
	public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeService.createEmployee(employeeDto);
	}

	@GetMapping
	public List<EmployeeDto> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public EmployeeDto getEmployeeById(@PathVariable("id") Integer employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	@PutMapping("/{id}")
	public EmployeeDto updateEmployee(@PathVariable("id") Integer employeeId, @RequestBody EmployeeDto employeeDto) {
		return employeeService.updateEmployee(employeeId, employeeDto);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") Integer employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}
}
