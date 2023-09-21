package com.mapping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    private String departmentName;

    @ManyToMany
//    @JoinTable(name = "student-department",
//            joinColumns = @JoinColumn(name = "department", referencedColumnName = "departmentId"),
//            inverseJoinColumns = @JoinColumn(name = "student", referencedColumnName = "studentId")
//    )
    private List<Student> students = new ArrayList<>();
}
