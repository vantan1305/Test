package com.example.object.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="project")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Projects implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_project")
    @SequenceGenerator(name = "seq_project", sequenceName = "seq_project", allocationSize = 1, initialValue = 1)
    @Column(name = "id" ,nullable = false)
    private Long ID;
    @Column(name = "name" ,nullable = false)
    private String name;
    @Column(name = "description" ,nullable = false)
    private String description;
    @Column(name = "status" ,nullable = false)
    private int status;
    @Column(name = "timestart" ,nullable = false)
    @Temporal(TemporalType.DATE)
    private Date timestart;
    @Column(name = "timeend" ,nullable = false)
    @Temporal(TemporalType.DATE)
    private  Date timeend;
    @OneToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Issue> issues ;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<ProjectEmployee> projectEmployees;
}
