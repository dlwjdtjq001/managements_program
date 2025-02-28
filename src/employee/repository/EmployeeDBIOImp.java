package employee.repository;
import employee.config.DbUtil;

import java.sql.Connection;

public class EmployeeDBIOImp implements EmployeeDBIO {
    EmployeeManager employeeManager;
    Connection conn = DbUtil.getConnection();

    public EmployeeDBIOImp(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }


}
