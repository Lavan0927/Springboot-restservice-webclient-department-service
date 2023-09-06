package com.example.departmentservice.controller;

import com.example.departmentservice.response.DepartmentResponse;
import com.example.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department/{studentId}")
    public ResponseEntity<DepartmentResponse> getDepartmentByStudentId(@PathVariable("studentId") int studentId){
        DepartmentResponse departmentResponse = departmentService.findDepartmentByStudentId(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(departmentResponse);
    }
}
