package com.mapping.service;

import com.mapping.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(int studentId);

    List<StudentDto> getStudentByDepartments(int departmentId);

    void deleteStudent(int studentId);

}
