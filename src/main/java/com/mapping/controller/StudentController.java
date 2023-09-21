package com.mapping.controller;

import com.mapping.dto.StudentDto;
import com.mapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mapping")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto student = this.studentService.createStudent(studentDto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("studentId")int studentId){
        StudentDto studentById = this.studentService.getStudentById(studentId);
        return new ResponseEntity<>(studentById, HttpStatus.OK);
    }

    @GetMapping("/student/department/{departmentId}")
    public ResponseEntity<List<StudentDto>> getStudentByDepartment(@PathVariable("departmentId")int departmentId){
        List<StudentDto> studentByDepartments = this.studentService.getStudentByDepartments(departmentId);
        return new ResponseEntity<>(studentByDepartments, HttpStatus.OK);
    }

    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId){
        this.studentService.deleteStudent(studentId);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

}
