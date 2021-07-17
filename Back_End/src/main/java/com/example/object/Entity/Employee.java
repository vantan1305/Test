package com.example.object.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Employee")
    @SequenceGenerator(name = "seq_Employee", sequenceName = "seq_Employee", allocationSize = 1, initialValue = 1)
    @Column(name = "id" ,nullable = false)
    private Long ID;
    @Column(name = "firstname",nullable = false)
    private String firstname;
    @Column(name = "lastname",nullable = false)
    private String lastname;
    @Column(name = "middlename",nullable = false)
    private String middlename;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "role",nullable = false)
    private String role;
    @Column(name = "dob",nullable = false)
    @JsonFormat(pattern="yyyy-dd-MM")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "gender",nullable = false)
    private int gender;
    @Column(name = "phone",nullable = false)
    private String phone;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "type",nullable = false)
    private String type;
    @Column(name = "personalid",nullable = false)
    private String personalid;
    @Column(name = "address",nullable = false)
    private String address;
    @Column(name = "education",nullable = false)
    private String education;
    @Column(name = "school",nullable = false)
    private String school;
    @Column(name = "faculty",nullable = false)
    private String faculty;
    @Column(name = "course",nullable = false)
    private String course;
    @Temporal(TemporalType.DATE)
    @Column(name = "timejoin",nullable = false)
    @JsonFormat(pattern="yyyy-dd-MM")
    private Date timejoin;
    @Column(name = "status",nullable = false)
    private int status;

    @OneToMany(mappedBy = "Creator", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Issue> issues;

    @OneToMany(mappedBy = "Assignee", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Issue> issueCollection ;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<ProjectEmployee> projectEmployees;

    @OneToMany(mappedBy = "editor", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Change> changes;

}
