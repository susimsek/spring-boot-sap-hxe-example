package io.susimsek.saphxeexample.service;


import io.susimsek.saphxeexample.domain.Employee;
import io.susimsek.saphxeexample.exception.ConflictException;
import io.susimsek.saphxeexample.exception.ResourceNotFoundException;
import io.susimsek.saphxeexample.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	final EmployeeRepository employeeRepository;
	
	public long getCount() {
		long count = employeeRepository.count();
		return count;
	}
	
	public List<Employee> findAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee insertEmployee(Employee employee) {

		if (employeeRepository.existsByEmailIgnoreCase(employee.getEmail())) {
			throw new ConflictException("Employee", "email", employee.getEmail());
		}

		return employeeRepository.save(employee);
	}
	
	public Employee findEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		return employee;
	}
	
	public boolean deleteEmployee(long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		if(employee!=null) {
			employeeRepository.delete(employee);
			return true;
		}
		return false;
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
		if (!employeeRepository.existsById(id)) {
			throw new ResourceNotFoundException("Employee", "id", id);
		}
		return employeeRepository.save(employee);
	}

	@Override
	public Employee partialUpdateEmployee(long id, Employee employee) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

		if (existingEmployee.getFirstName() != null) {
			existingEmployee.setFirstName(existingEmployee.getFirstName());
		}

		if (existingEmployee.getLastName() != null) {
			existingEmployee.setLastName(existingEmployee.getLastName());
		}

		if (existingEmployee.getEmail() != null) {
			existingEmployee.setEmail(existingEmployee.getEmail());
		}

		return employeeRepository.save(existingEmployee);
	}
}