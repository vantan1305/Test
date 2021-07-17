package com.example.object.Controller;

import com.example.object.Entity.Employee;
import com.example.object.Payload.Request.LoginRequest;
import com.example.object.Payload.Response.JwtResponse;
import com.example.object.Payload.Response.MessageResponse;
import com.example.object.Repository.EmployeeRepository;
import com.example.object.Sercurity.JWT.JwtUtils;
import com.example.object.Sercurity.Service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class Auth {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.CreateToken(authentication);
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getEmployee().getID(),
                userDetails.getEmployee().getUsername(),
                userDetails.getEmployee().getRole()));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody Employee employee) {
        if (employeeRepository.existsByUsername(employee.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error:Username is already taken!"));
        }
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error:Email is already in use!"));
        }
        employee.setPassword(encoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
