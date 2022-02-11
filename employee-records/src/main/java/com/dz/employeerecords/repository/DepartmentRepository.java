package com.dz.employeerecords.repository;

import com.dz.employeerecords.embedded.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query(value = "select d.department_name from department d ",nativeQuery = true)
    List<String> getDepartmentNames();
}
