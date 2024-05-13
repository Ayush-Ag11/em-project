package com.management.emproject.Service;

import com.management.emproject.EmpEntity.EmployeeEntity;
import com.management.emproject.EmployeeRepository.EmployeeRepository;
import com.management.emproject.Model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    private final EmployeeRepository employeeRepository;

    public EmpServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Employee Data Saved Successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeList) {
            Employee emp = new Employee();
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setAge(employeeEntity.getAge());
            emp.setId(employeeEntity.getId());
            emp.setPhone(employeeEntity.getPhone());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public Employee readEmployee(Long id) {
        Optional<EmployeeEntity> emp = employeeRepository.findById(id);
        if (emp.isPresent()) {
            EmployeeEntity employeeEntity = emp.get();
            Employee employee = new Employee();
            employee.setName(employeeEntity.getName());
            employee.setEmail(employeeEntity.getEmail());
            employee.setAge(employeeEntity.getAge());
            employee.setId(employeeEntity.getId());
            employee.setPhone(employeeEntity.getPhone());
            return employee;
        } else {
            return null; // Return null if the employee with the given id is not found
        }
    }

    @Override
    public boolean deleteEmployee(Long id) {
        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeEntity emp = optionalEmployee.get();
            employeeRepository.delete(emp);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean deleteAllEmployees() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        employeeRepository.deleteAll(employeeList);
        return true;
    }

    @Override
    public boolean updateEmployee(Long id, Employee employee) {
        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeEntity emp = optionalEmployee.get();
            emp.setName(employee.getName());
            emp.setEmail(employee.getEmail());
            emp.setAge(employee.getAge());
            emp.setPhone(employee.getPhone());
            employeeRepository.save(emp);
            return true;
        } else {
            return false;
        }
    }
}
