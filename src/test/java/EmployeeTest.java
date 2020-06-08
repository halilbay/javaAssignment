import com.java.assignment.*;

import com.java.assignment.ReadingFile;

import java.io.IOException;
import java.util.*;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.*;


public class EmployeeTest {
    Employee e1 = new Employee(102, "Didem", "Cicek", 400, Department.production, null);
    Employee e3 = new Employee(105, "Halil", "Bay", 300, Department.sales, null);
    Employee e2 = new Employee(101, "Kamil", "Abitoglu", 100, Department.sales, new Employee(105));

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
        assertEquals(Department.production, e1.getDepartment());
    }

    @org.junit.jupiter.api.Test
    void getAllEmployees() throws IOException {
        Map<Integer, Employee> employeeList = new HashMap<>();
        String absPath = "/home/bay/Documents/workSpace/javaAssignment/src/main/resources/";
        String employeeFileName = absPath + "employees.txt";
        ReadingFile fileEmployee = new ReadingFile(employeeFileName);

        List<String[]> allEmployees = fileEmployee.getAllLines();
        for (String[] employee: allEmployees) {
            // id|firstName|lastName|salary|department|manager|sales|projects
            int id = parseInt(employee[0]);
            String firstName = employee[1];
            String lastName = employee[2];
            int salary = parseInt(employee[3]);
            Department department = Department.valueOf(employee[4]);
            Employee manager = null;
            if (!employee[5].equals("-")) {
                manager = new Employee(parseInt(employee[5]));
            }

            Set<Sale> sales = null;
            if (!employee[6].equals("-")) {
                sales = new HashSet<>();
                for (String s : employee[6].split(",")) {
                    sales.add(new Sale(s));
                }
            }

            Set<Project> projects = null;
            if (!employee[7].equals("-")) {
                projects = new HashSet<>();
                for (String s : employee[7].split(",")) {
                    projects.add(new Project(s));
                }
            }
            Employee e1 = new Employee(id, firstName, lastName, salary, department, manager);
            e1.sales = sales;
            e1.projects = projects;
            employeeList.put(id, e1);

        }

        for (Map.Entry<Integer, Employee> entry: employeeList.entrySet()){
            System.out.println(entry.getValue().toString());
            System.out.println(entry.getValue().isManager());
            System.out.println(entry.getValue().getProjects());
            System.out.println(entry.getValue().getSales());
        }
        System.out.println(employeeList.values());
    }
}
