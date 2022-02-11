package com.dz.employeerecords.embedded;

import com.dz.employeerecords.domain.Employee;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departmentName;

    @OneToMany(mappedBy = "department", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<SalaryDetails> salaryDetails;

//    @OneToOne(mappedBy = "department")
//    private Employee employee;


}
