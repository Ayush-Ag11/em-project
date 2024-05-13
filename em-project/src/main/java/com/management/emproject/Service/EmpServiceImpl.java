package com.management.emproject.Service;

import com.management.emproject.EmpEntity.EmployeeEntity;
import com.management.emproject.EmployeeRepository.EmployeeRepository;
import com.management.emproject.Model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;



    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity  = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Employee Data Saved Successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (Employee employeeEntity : employeeList) {

        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(int id) {
       employees.remove(id);
       return true;
    }
}
