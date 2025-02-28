package employee.repository;

public class EmployeeManager {
    private static EmployeeManager employeeManagerSingleton = new EmployeeManager();
    private EmployeeDBIO employeeDBIO = new EmployeeDBIOImp(employeeManagerSingleton);

    public static EmployeeManager getInstance() {
        return employeeManagerSingleton;
    }

    public EmployeeDBIO getEmployeeDBIO() {
        return employeeDBIO;
    }

    public void setEmployeeDBIO(EmployeeDBIO employeeDBIO) {
        this.employeeDBIO = employeeDBIO;
    }
}
