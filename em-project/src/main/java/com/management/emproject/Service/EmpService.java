package com.management.emproject.Service;

import com.management.emproject.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpService {

    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    boolean updateEmployee(Long id, Employee employee);

   Employee readEmployee(Long id);
}
