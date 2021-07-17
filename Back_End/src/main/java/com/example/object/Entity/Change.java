package com.example.object.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Change")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Change implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_Change")
    @SequenceGenerator(name = "Seq_Change", sequenceName = "Seq_Change", allocationSize = 1, initialValue = 1)
    @Column(name = "id" ,nullable = false)
    private Long ID;
    @Temporal(TemporalType.DATE)
    @Column(name = "Timestart" ,nullable = false)
    private Date Timestart ;
    @Temporal(TemporalType.DATE)
    @Column(name = "Timeend" ,nullable = false)
    private Date Timeend ;
    @Column(name = "Title" ,nullable = false)
    private  String Title ;
    @Column(name = "Description" ,nullable = false)
    private  String Description;
    @Temporal(TemporalType.DATE)
    @Column(name = "Timechange" ,nullable = false)
    private  Date  Timechange;
    @Column(name = "Solution" ,nullable = false)
    private String Solution;
    @Column(name = "Status" ,nullable = false)
    private int Status;
    @Column(name = "Type" ,nullable = false)
    private int Type;
    @Column(name = "Target" ,nullable = false)
    private int Target;
    @Column(name = "Priority" ,nullable = false)
    private int Priority;
    @Column(name = "Comments" ,nullable = false)
    private String Comments;


    @ManyToOne
    @JoinColumn(name="Issue_ID", nullable=false,referencedColumnName = "ID")
    private  Issue change;

    @ManyToOne
    @JoinColumn(name="Editor", nullable=false,referencedColumnName = "ID")
    private  Employee editor;
}
