package com.dz.employeerecords.domain;

import com.dz.employeerecords.embedded.Department;
import com.dz.employeerecords.embedded.SalaryDetails;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String gender;

    private String mobile;

    private String address;

    private String email;

    private String department;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "department_id", referencedColumnName = "id")
//    private Department department;




}
