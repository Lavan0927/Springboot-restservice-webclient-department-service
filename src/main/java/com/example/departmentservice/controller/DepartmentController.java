package com.example.departmentservice.controller;

import com.example.departmentservice.entity.Department;
import com.example.departmentservice.response.DepartmentResponse;
import com.example.departmentservice.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/department")
@Api(tags = "Department Management")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{studentId}")
    @Operation(summary = "Get department info by providing studentId",security = @SecurityRequirement(name = "Authorization"), responses =
            {@ApiResponse(content = @Content(schema = @Schema(implementation = Department.class)))})
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved department by Id"),
            @ApiResponse(responseCode = "400", description = "Department not found") })
    public ResponseEntity<DepartmentResponse> getDepartmentByStudentId(@PathVariable("studentId") int studentId){
        DepartmentResponse departmentResponse = departmentService.findDepartmentByStudentId(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(departmentResponse);
    }
}
