package com.management.emproject.Controller;

import com.management.emproject.Model.Employee;
import com.management.emproject.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    final
    EmpService empService;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return empService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return empService.readEmployee(id);
    }

    @PostMapping("employees")
    public String addEmployee(@RequestBody Employee employee) {
        return empService.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String removeEmployee(@PathVariable Long id) {
        if (empService.deleteEmployee(id)) {
            return "Deleted Successfully";
        }
        return "Deleted Failure";
    }

    @DeleteMapping("employees")
    public String removeEmployees() {
        if (empService.deleteAllEmployees()) {
            return "Deleted Successfully";
        }
        return "Deleted Failure";
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        if (empService.updateEmployee(id, employee)) {
            return "Updated Successfully";
        }
        return "Updated Failure";
    }
}
