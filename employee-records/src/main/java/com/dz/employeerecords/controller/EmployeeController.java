package com.dz.employeerecords.controller;

import com.dz.employeerecords.domain.Employee;
import com.dz.employeerecords.dto.ApiResponse;
import com.dz.employeerecords.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@Slf4j
@CrossOrigin(allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"},
        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/saveEmployee")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
        ApiResponse apiResponse = new ApiResponse();
        System.out.println(employee.toString());
        apiResponse.setMessage("Employee saved successfully");
        apiResponse.setStatusCode(HttpStatus.OK.value());
        Employee employee1 = employeeRepository.save(employee);
        System.out.println(employee1.getId());
        apiResponse.setResult(employee1);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<?> getAllEmployee(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("All Employee List");
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setResult(employeeRepository.findAll());
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<?> deleteEmployee(@RequestParam Long id){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Employee deleted successfully");
        apiResponse.setStatusCode(HttpStatus.OK.value());
        employeeRepository.deleteById(id);
        return ResponseEntity.ok(apiResponse);
    }

}
