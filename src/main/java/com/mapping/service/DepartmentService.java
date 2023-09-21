package com.mapping.service;

import com.mapping.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto, int studentId);

    List<DepartmentDto> getDepartmentByStudent(int studentId);

    List<DepartmentDto> findDepartmentByStudent(int studentId);

    void deleteDepartment(int departmentId);

}
