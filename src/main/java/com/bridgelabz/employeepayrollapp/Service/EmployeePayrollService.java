package com.bridgelabz.employeepayrollapp.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
       List<EmployeePayrollData> employeePayrollDataList=new ArrayList<>();
       employeePayrollDataList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Shahazd", 5000)));
       return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        EmployeePayrollData employeePayrollData=null;
        employeePayrollData=new EmployeePayrollData(1,new EmployeePayrollDTO("Shahazd", 5000));
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData=null;
        employeePayrollData=new EmployeePayrollData(2, employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData=null;
        employeePayrollData=new EmployeePayrollData(empId,employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {

    }
}
