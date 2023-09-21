package com.mapping.repository;

import com.mapping.entity.Department;
import com.mapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    List<Department> findByStudents(Student student);

    // this will not work.
    @Query(value = "select d from Department d where d.students= :student")
    List<Department> getDepartmentByStudent(@Param("student") Student student);

}
