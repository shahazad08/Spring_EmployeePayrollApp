package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Employee name Invalid")
    @NotEmpty(message = "Employee Name can't be null")
    public String name;

    @Min(value = 500, message = "Min Wage should be more than 500")
    public long salary;

    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    public LocalDate startDate;

    public String note;

    public String profilePic;

    public List<String> departments;

}
