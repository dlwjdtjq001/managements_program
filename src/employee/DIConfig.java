package employee;

import employee.config.DbUtil;
import employee.controller.EmployeeOutput;
import employee.controller.EmployeeOutputImp;
import employee.repository.EmployeeDBIO;
import employee.repository.EmployeeDBIOImp;
import employee.repository.EmployeeManager;
import employee.service.EmployeeInput;
import employee.service.EmployeeInputImp;
import employee.service.SearchEmployee;
import employee.service.SearchEmployeeImp;

public class DIConfig {
    public EmployeeDBIO getEmployeeDBIO() {
        return new EmployeeDBIOImp(EmployeeManager.getInstance());
    }

    public EmployeeInput getEmployeeInput() {
        return new EmployeeInputImp(getEmployeeDBIO());
    }

    public SearchEmployee getSearchEmployee() {
        return new SearchEmployeeImp(getEmployeeDBIO());
    }

    public EmployeeOutput getEmployeeOutput() {
        return new EmployeeOutputImp(getEmployeeInput(), getSearchEmployee());
    }
}
