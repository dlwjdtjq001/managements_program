package employee.service;

import employee.repository.EmployeeDBIO;

public class SearchEmployeeImp implements SearchEmployee {
    private EmployeeDBIO employeeDBIO;

    public SearchEmployeeImp(EmployeeDBIO employeeDBIO) {
        this.employeeDBIO = employeeDBIO;
    }
}
