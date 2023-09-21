package com.mapping.controller;

import com.mapping.dto.DepartmentDto;
import com.mapping.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mapping")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department/student/{studentId}")
    public ResponseEntity<DepartmentDto> createDepartment(
            @RequestBody DepartmentDto departmentDto,
            @PathVariable("studentId") int studentId
    ){
        DepartmentDto department = this.departmentService.createDepartment(departmentDto, studentId);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @GetMapping("/department/student/{studentId}/get")
    public ResponseEntity<List<DepartmentDto>> getDepartmetByStudent(@PathVariable("studentId") int studentId){
        List<DepartmentDto> departmentByStudent = this.departmentService.getDepartmentByStudent(studentId);
        return new ResponseEntity<>(departmentByStudent, HttpStatus.OK);
    }

    @GetMapping("/department/student/{studentId}/find")
    public ResponseEntity<List<DepartmentDto>> findDepartmentByStudent(@PathVariable("studentId") int studentId){
        List<DepartmentDto> departmentByStudent = this.departmentService.findDepartmentByStudent(studentId);
        return new ResponseEntity<>(departmentByStudent, HttpStatus.OK);
    }

    @DeleteMapping("/department/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("departmentId") int departmentId){
        this.departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
