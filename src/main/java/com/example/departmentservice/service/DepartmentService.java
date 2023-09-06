package com.example.departmentservice.service;

import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepo;
import com.example.departmentservice.response.DepartmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Optional;


@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

   @Autowired
   private ModelMapper mapper;

    public DepartmentResponse findDepartmentByStudentId(int studentId){
        Optional<Department> departmentByStudentId = departmentRepo.findDepartmentByStudentId(studentId);
        DepartmentResponse departmentResponse = mapper.map(departmentByStudentId,DepartmentResponse.class);
        return departmentResponse;

    }



}
