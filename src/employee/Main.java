package employee;

import employee.controller.EmployeeOutput;

public class Main {
    public static void main(String[] args) {
        DIConfig config = new DIConfig();
        EmployeeOutput employeeOutput = config.getEmployeeOutput();
    }
}
