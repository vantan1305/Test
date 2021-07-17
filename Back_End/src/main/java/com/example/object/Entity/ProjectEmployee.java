package com.example.object.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name="Projectemployee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Issue")
    @SequenceGenerator(name = "seq_Issue", sequenceName = "seq_Issue", allocationSize = 1, initialValue = 1)
    @Column(name = "ID" ,nullable = false)
    private Long ID;
    @Column(name = "Manager" ,nullable = false)
    private int Manager;

    @ManyToOne
    @JoinColumn(name="Project_ID", nullable=false,referencedColumnName = "ID")
    private  Projects project;

    @ManyToOne
    @JoinColumn(name="Employee_ID", nullable=false,referencedColumnName = "ID")
    private  Employee employee;
}
