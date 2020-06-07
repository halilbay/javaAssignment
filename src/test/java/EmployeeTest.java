import com.java.assignment.Department;
import com.java.assignment.Employee;

import static org.junit.jupiter.api.Assertions.*;


public class EmployeeTest {
    Employee e1 = new Employee(102, "Didem", "Cicek", 400, Department.PROJECTS, null);
    Employee e3 = new Employee(105, "Halil", "Bay", 300, Department.SALES, null);
    Employee e2 = new Employee(101, "Kamil", "Abitoglu", 100, Department.SALES, new Employee(105));

    @org.junit.jupiter.api.Test
    void getFullName(){
        assertEquals("Didem Cicek", e1.getFullName());
    }

    @org.junit.jupiter.api.Test
    void isManager(){
        assertFalse(e2.isManager());
    }

    @org.junit.jupiter.api.Test
    void getManager(){
        assertEquals(105, e2.getManager().getId());
    }

    @org.junit.jupiter.api.Test
    void getDepartment(){
        assertEquals(Department.PROJECTS, e1.getDepartment());
    }
}
