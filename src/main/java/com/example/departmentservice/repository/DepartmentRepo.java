package com.example.departmentservice.repository;

import com.example.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    @Query(
       nativeQuery = true,
            value = "SELECT d.department_id, d.department_name FROM db.department d join db.student s on s.student_id = d.student_id where d.student_id=:studentId")
        Optional<Department> findDepartmentByStudentId(@Param("studentId") int studentId);
}
