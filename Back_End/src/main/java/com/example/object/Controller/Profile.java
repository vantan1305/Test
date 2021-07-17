package com.example.object.Controller;

import com.example.object.Entity.Employee;
import com.example.object.Payload.Response.ProfileResponse;
import com.example.object.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/profile")
public class Profile {
    @Autowired
    private  EmployeeService employeeService;
    @Autowired
    private  ModelMapper mapper;
    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ROLE_MENBER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_PM') or hasRole('ROLE_MANAGER')")
    public ProfileResponse getProfile(@PathVariable("id") Long id) {
        Employee employee = employeeService.findByID(id);
        return ProfileResponse.build(employee);
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_MENBER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_PM') or hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> updateProfile (@RequestBody ProfileResponse profileResponse){
        Employee employee = employeeService.findByID(profileResponse.getID());
        mapper.map(profileResponse,employee);
        employeeService.updateEmployee(employee);
        return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }
}
