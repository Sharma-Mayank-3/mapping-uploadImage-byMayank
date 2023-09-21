package com.mapping.serviceImpl;

import com.mapping.dto.StudentDto;
import com.mapping.entity.Department;
import com.mapping.entity.Student;
import com.mapping.repository.DepartmentRepo;
import com.mapping.repository.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements com.mapping.service.StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student map = this.modelMapper.map(studentDto, Student.class);
        Student save = this.studentRepo.save(map);
        return this.modelMapper.map(save, StudentDto.class);
    }

    @Override
    public StudentDto getStudentById(int studentId) {
        Student student = this.studentRepo.findById(studentId).orElseThrow(() -> new RuntimeException("not found studrnt"));
        return this.modelMapper.map(student, StudentDto.class);

    }

    @Override
    public List<StudentDto> getStudentByDepartments(int departmentId) {
        Department department = this.departmentRepo.findById(departmentId).orElseThrow(() -> new RuntimeException("not found department"));
        List<Student> students = department.getStudents();
        List<StudentDto> collect = students.stream().map(student -> this.modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteStudent(int studentId) {
        Student student = this.studentRepo.findById(studentId).orElseThrow(() -> new RuntimeException("not found studrnt"));
        this.studentRepo.delete(student);
    }
}
