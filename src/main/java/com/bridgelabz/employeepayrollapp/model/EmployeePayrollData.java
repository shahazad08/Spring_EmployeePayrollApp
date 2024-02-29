package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public @Data class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> departments;


    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.updateEmployeePayrollData(employeePayrollDTO);

    }

    public void updateEmployeePayrollData( EmployeePayrollDTO employeePayrollDTO) {
        this.name= employeePayrollDTO.name;
        this.salary=employeePayrollDTO.salary;
        this.startDate=employeePayrollDTO.startDate;
        this.note=employeePayrollDTO.note;
        this.profilePic=employeePayrollDTO.profilePic;
        this.departments=employeePayrollDTO.departments;
    }


}
