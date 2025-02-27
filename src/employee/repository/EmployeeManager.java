package employee.repository;

public class EmployeeManager {
    private static EmployeeManager employeeManagerSingleton = new EmployeeManager();
    private EmployeeDBIO employeeDBIO = new EmployeeDBIOImp();

    public static EmployeeManager getInstance() {
        return employeeManagerSingleton;
    }

    public EmployeeDBIO getEmployeeDBIO() {
        return employeeDBIO;
    }
}
