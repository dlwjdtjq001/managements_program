package employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private String eno;
    private String name;
    private int enteryear;
    private int entermonth;
    private String role;
    private String secno;
    private double salary;

    public EmployeeDto(String eno, String name, int enteryear, int entermonth, String role, String secno, double salary) {
        this.eno = eno;
        this.name = name;
        this.enteryear = enteryear;
        this.entermonth = entermonth;
        this.role = role;
        this.secno = secno;
        this.salary = salary;
    }

    public void payRaiseRate() {
        switch (role) {
            case "manager": salary *= 1.3; break;
            case "staff": salary *= 1.2; break;
            case "secretary": salary *= 1.1; break;
        }
    }
}
