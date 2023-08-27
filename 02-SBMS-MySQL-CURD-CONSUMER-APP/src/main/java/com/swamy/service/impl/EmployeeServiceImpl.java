package com.swamy.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swamy.client.EmployeeClient;
import com.swamy.dto.EmployeeDto;
import com.swamy.exception.ResourceNotFoundException;
import com.swamy.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeClient employeeClient;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = null;
		try {
			savedEmployee = employeeClient.saveEmployee(employeeDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return savedEmployee;

	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<EmployeeDto> employeesList = null;

		try {
			employeesList = employeeClient.getAllEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeesList;

	}

	@Override
	public EmployeeDto getEmployeeById(Integer employeeId) {
		EmployeeDto employeeDto = null;

		try {
			employeeDto = employeeClient.getEmployeeById(employeeId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Employee Not Found With Id : " + employeeId);
		}
		return employeeDto;
	}

	@Override
	public EmployeeDto updateEmployee(Integer employeeId, EmployeeDto employeeDto) {

		EmployeeDto updatedEmployee = null;

		try {
			getEmployeeById(employeeId);

			updatedEmployee = employeeClient.updateEmployee(employeeId, employeeDto);

		} catch (Exception e) {
			throw new ResourceNotFoundException("Employee Not Found With Id : " + employeeId);
		}

		return updatedEmployee;
	}

	@Override
	public String deleteEmployee(Integer employeeId) {

		String message = null;

		try {
			message = employeeClient.deleteEmployee(employeeId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Employee Not Found With Id : " + employeeId);
		}

		return message;
	}
}
