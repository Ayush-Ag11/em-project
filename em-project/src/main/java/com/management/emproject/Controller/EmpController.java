package com.management.emproject.Controller;

import com.management.emproject.Model.Employee;
import com.management.emproject.Service.EmpService;
import com.management.emproject.Service.EmpServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

   EmpService empService = new EmpServiceImpl();

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return empService.readEmployees();
    }

    @PostMapping("employees")
    public String addEmployee(@RequestBody Employee employee) {
       // employees.add(employee);
        return empService.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String removeEmployee(@PathVariable int id) {
        if (empService.deleteEmployee(id)) {
            return "Deleted Successfully";
        }
        return "Deleted Failure";
    }
}
