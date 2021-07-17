package com.example.object.Service;

import com.example.object.Entity.Employee;
import com.example.object.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    private  final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee findByUsername(String username){
        return employeeRepository.findByUsername(username);
    }
    public Employee findByID(Long id){
        return employeeRepository.getById(id);
    }
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
