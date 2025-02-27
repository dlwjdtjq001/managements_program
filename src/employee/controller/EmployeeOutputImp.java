package employee.controller;

import employee.service.EmployeeInput;
import employee.service.SearchEmployee;

public class EmployeeOutputImp implements EmployeeOutput{
    EmployeeInput employeeInput;
    SearchEmployee searchEmployee;

    public EmployeeOutputImp(EmployeeInput employeeInput, SearchEmployee searchEmployee) {
        this.employeeInput = employeeInput;
        this.searchEmployee = searchEmployee;
    }

}
