package com.example.object.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="issue")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Issue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Issue")
    @SequenceGenerator(name = "seq_Issue", sequenceName = "seq_Issue", allocationSize = 1, initialValue = 1)
    @Column(name = "ID" ,nullable = false)
    private Long ID;
    @Column(name = "Status")
    private int Status;

    @OneToMany(mappedBy = "change", cascade = CascadeType.ALL)
    private Collection<Change> Changes;

    @ManyToOne
    @JoinColumn(name="Creator", nullable=false,referencedColumnName = "ID")
    private Employee Creator;

    @ManyToOne
    @JoinColumn(name="Assignee", nullable=false,referencedColumnName = "ID")
    private Employee Assignee;

    @ManyToOne
    @JoinColumn(name="Project_ID", nullable=false,referencedColumnName = "ID")
    private Projects projects;


    @OneToMany(mappedBy = "change", cascade = CascadeType.ALL)
    @JsonIgnore
    private  Collection<Change>  changes;

    @JsonIgnore
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinColumn(name="Parent")
    private  Collection<Issue>  Child;

    @Column(name="Parent", insertable=false, updatable=false)
    private Long  parentId;

}
