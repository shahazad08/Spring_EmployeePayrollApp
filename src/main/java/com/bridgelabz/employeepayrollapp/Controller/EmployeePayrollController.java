package com.bridgelabz.employeepayrollapp.Controller;

import com.bridgelabz.employeepayrollapp.Service.IEmployeePayrollService;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayroll")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService iEmployeePayrollService;

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> empDataList=null;
        empDataList=iEmployeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success",empDataList); // Response DTO
        responseDTO.getData();
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    // Same as a Get Method
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable("empId") int empId){
        EmployeePayrollData employeePayrollData=null;
        employeePayrollData=iEmployeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for Id Successfull",employeePayrollData); // Response DTO
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@PathVariable String department) {

        List<EmployeePayrollData> employeeList = null;
        employeeList = iEmployeePayrollService.getEmployeesByDepartment(department);
        ResponseDTO response = new ResponseDTO("Get Call for Department Successful", employeeList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO){
        log.debug(employeePayrollDTO.toString());
        EmployeePayrollData employeePayrollData=null;
        employeePayrollData=iEmployeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create Employee payroll data for:", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid  @PathVariable("empId") int empId, @RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData employeePayrollData=null;
        employeePayrollData=iEmployeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Employee payroll Data for: ", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        iEmployeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: ", "employeeId "+empId);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
