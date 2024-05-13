package com.management.emproject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String Name;

    private int Age;

    private String Email;

    private String Phone;

    private int id;
}
