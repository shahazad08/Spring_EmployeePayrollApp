package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
public @Data class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name ="name")
    private String name;

    private String gender;

    private long salary;
    public LocalDate startDate;
    public String note;
    public String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department",
    joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    public List<String> departments;

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {

        this.updateEmployeePayrollData(employeePayrollDTO);

    }

    public EmployeePayrollData() {

    }

    public void updateEmployeePayrollData( EmployeePayrollDTO employeePayrollDTO) {
        this.name= employeePayrollDTO.name;
        this.gender=employeePayrollDTO.gender;
        this.salary=employeePayrollDTO.salary;
        this.startDate=employeePayrollDTO.startDate;
        this.note=employeePayrollDTO.note;
        this.profilePic=employeePayrollDTO.profilePic;
        this.departments=employeePayrollDTO.departments;
    }


}
