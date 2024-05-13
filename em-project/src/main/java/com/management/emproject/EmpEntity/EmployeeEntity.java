package com.management.emproject.EmpEntity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_db")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String email;

    private String phone;
}
