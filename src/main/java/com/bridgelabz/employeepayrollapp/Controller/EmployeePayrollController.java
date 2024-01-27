package com.bridgelabz.employeepayrollapp.Controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        EmployeePayrollData employeePayrollData=null;
        employeePayrollData=new EmployeePayrollData(1,new EmployeePayrollDTO("Shahazad", 500000)); //  Employee Payroll DTO
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success",employeePayrollData); // Response DTO
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    // Same as a Get Method
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
        EmployeePayrollData employeePayrollData=null;
        employeePayrollData=new EmployeePayrollData(1,new EmployeePayrollDTO("Shahazad", 500000)); //  Employee Payroll DTO
        ResponseDTO responseDTO = new ResponseDTO("Get Call for Id Successfull",employeePayrollData); // Response DTO
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData employeePayrollData=null;
        employeePayrollData=new EmployeePayrollData(2, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create Employee payroll data for:", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId, @RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData employeePayrollData=null;
        employeePayrollData=new EmployeePayrollData(empId,employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Employee payroll Data for: ", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: ", "employeeId "+empId);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
