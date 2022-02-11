package com.dz.employeerecords.controller;

import com.dz.employeerecords.dto.ApiResponse;
import com.dz.employeerecords.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@Slf4j
@CrossOrigin(allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"},
        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})

public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/getDepartmentName")
    public ResponseEntity<?> getDepartmentName(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setMessage("Department List");
//        apiResponse.setResult(departmentRepository.getDepartmentNames());
        apiResponse.setResult(departmentRepository.findAll());
        return ResponseEntity.ok(apiResponse);
    }
}
