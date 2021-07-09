package com.example.object.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE")
    @SequenceGenerator(name = "SEQ_EMPLOYEE", sequenceName = "SEQ_EMPLOYEE", allocationSize = 1, initialValue = 1)
    @Column(name = "id" ,nullable = false)
    private Long ID;
//    @Column(name = "firstname",nullable = false)
//    private String firstname;
//    @Column(name = "lastname",nullable = false)
//    private String lastname;
//    @Column(name = "middlename",nullable = false)
//    private String middlename;
//    @Column(name = "dob",nullable = false)
//    @Temporal(TemporalType.DATE)
//    private Date dob;
//    @Column(name = "gender",nullable = false)
//    private int gender;
//    @Column(name = "phone",nullable = false)
//    private String phone;
    @Column(name = "email",nullable = false)
    private String email;
//    @Column(name = "type",nullable = false)
//    private String type;
//    @Column(name = "ic",nullable = false)
//    private String ic;
//    @Column(name = "numberhouse",nullable = false)
//    private String numberhouse;
//    @Column(name = "street",nullable = false)
//    private String street;
//    @Column(name = "city",nullable = false)
//    private String city;
//    @Column(name = "country",nullable = false)
//    private String country;
//    @Column(name = "university",nullable = false)
//    private String university;
//    @Column(name = "course",nullable = false)
//    private String course;
//    @Column(name = "faculty",nullable = false)
//    private String faculty;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "role",nullable = false)
    private String role;
    public Employee(String email, String username, String password, String role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
