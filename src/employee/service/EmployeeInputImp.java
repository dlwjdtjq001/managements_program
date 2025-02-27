package employee.service;

import employee.repository.EmployeeDBIO;

public class EmployeeInputImp implements EmployeeInput {
    private EmployeeDBIO employeeDBIO;

    public EmployeeInputImp(EmployeeDBIO employeeDBIO) {
        this.employeeDBIO = employeeDBIO;
    }
}
