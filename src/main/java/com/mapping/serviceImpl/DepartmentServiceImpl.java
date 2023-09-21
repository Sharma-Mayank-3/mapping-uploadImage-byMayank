package com.mapping.serviceImpl;

import com.mapping.dto.DepartmentDto;
import com.mapping.entity.Department;
import com.mapping.entity.Student;
import com.mapping.repository.DepartmentRepo;
import com.mapping.repository.StudentRepo;
import com.mapping.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto, int studentId) {
        Student student = this.studentRepo.findById(studentId).orElseThrow(() -> new RuntimeException("not found studrnt"));
        Department map = this.modelMapper.map(departmentDto, Department.class);
        List<Student> students = new ArrayList<>();
        students.add(student);
        map.setStudents(students);
        Department save = this.departmentRepo.save(map);
        return this.modelMapper.map(save, DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getDepartmentByStudent(int studentId) {
        Student student = this.studentRepo.findById(studentId).orElseThrow(() -> new RuntimeException("not found studrnt"));
        List<Department> departmentByStudent = this.departmentRepo.getDepartmentByStudent(student);
        return departmentByStudent.stream().map(department -> this.modelMapper.map(department, DepartmentDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<DepartmentDto> findDepartmentByStudent(int studentId) {
        Student student = this.studentRepo.findById(studentId).orElseThrow(() -> new RuntimeException("not found studrnt"));
        List<Department> departmentByStudent = this.departmentRepo.findByStudents(student);
        return departmentByStudent.stream().map(department -> this.modelMapper.map(department, DepartmentDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteDepartment(int departmentId) {
        Department department = this.departmentRepo.findById(departmentId).orElseThrow(() -> new RuntimeException("not found department"));
        this.departmentRepo.delete(department);
    }
}
