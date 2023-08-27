package com.swamy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.swamy.dto.EmployeeDto;
import com.swamy.entity.Employee;
import com.swamy.exception.ResourceNotFoundException;
import com.swamy.props.AppProperties;
import com.swamy.repository.EmployeeRepository;
import com.swamy.service.EmployeeService;
import com.swamy.utils.AppConstants;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AppProperties appProperties;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);

		Employee savedEmployee = employeeRepository.save(employee);

		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {

		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class))
				.collect(Collectors.toList());

	}

	@Cacheable(value = "employee", key = "#employeeId")
	@Override
	public EmployeeDto getEmployeeById(Integer employeeId) {

		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(
				String.format(appProperties.getMessages().get(AppConstants.EMP_NOT_FOUND), employeeId)));

		return modelMapper.map(employee, EmployeeDto.class);
	}

	@CachePut(value = "employee", key = "#employeeId")
	@Override
	public EmployeeDto updateEmployee(Integer employeeId, EmployeeDto employeeDto) {

		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(
				String.format(appProperties.getMessages().get(AppConstants.EMP_NOT_FOUND), employeeId)));

		employee.setEmployeeName(employeeDto.getEmployeeName());
		employee.setEmployeeSalary(employeeDto.getEmployeeSalary());
		employee.setEmployeeAddress(employeeDto.getEmployeeAddress());

		Employee updatedEmployee = employeeRepository.save(employee);

		return modelMapper.map(updatedEmployee, EmployeeDto.class);
	}

	@CacheEvict(value = "employee", key = "#employeeId")
	@Override
	public String deleteEmployee(Integer employeeId) {

		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(
				String.format(appProperties.getMessages().get(AppConstants.EMP_NOT_FOUND), employeeId)));

		employeeRepository.deleteById(employee.getEmployeeId());

		return appProperties.getMessages().get(AppConstants.EMP_DELETION_SUCCESS) + employeeId;
	}

}
