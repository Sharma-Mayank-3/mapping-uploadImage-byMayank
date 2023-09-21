package com.mapping.dto;

import com.mapping.entity.Student;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private int departmentId;

    private String departmentName;

    private List<StudentDto> students = new ArrayList<>();
}
