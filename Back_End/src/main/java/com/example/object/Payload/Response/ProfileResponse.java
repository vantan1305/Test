package com.example.object.Payload.Response;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import com.example.object.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ProfileResponse implements Serializable {
    private Long ID;
    private String username;
    private String firstname;
    private String lastname;
    private String middlename;
    private Date dob;
    private int gender;
    private String phone;
    private String email;
    private String address;
    private String education;
    private String school;
    private String faculty;
    private String course;
    public  static  ProfileResponse build (Employee employee){
        return new ProfileResponse(
                employee.getID(),
                employee.getUsername(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getMiddlename(),
                employee.getDob(),
                employee.getGender(),
                employee.getPhone(),
                employee.getEmail(),
                employee.getAddress(),
                employee.getEducation(),
                employee.getSchool(),
                employee.getFaculty(),
                employee.getCourse()
        );
    }
}
