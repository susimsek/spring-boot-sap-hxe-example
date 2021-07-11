package io.susimsek.saphxeexample.service;

import io.susimsek.saphxeexample.domain.Employee;

import java.util.List;

public interface EmployeeService {

    long getCount();
    List<Employee> findAllEmployee();
    Employee insertEmployee(Employee employee);
    Employee findEmployeeById(Long id);
    boolean deleteEmployee(long id);
    Employee updateEmployee(long id, Employee employee);

    Employee partialUpdateEmployee(long id, Employee employee);
}
