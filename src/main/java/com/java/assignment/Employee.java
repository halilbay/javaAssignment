package com.java.assignment;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Person{
    /*
    * id|firstName|lastName|salary|department|manager|sales|projects
    * */
    private int salary;
    private Enum<Department> department;
    private Employee manager;
    private final List<Sale> sales = new ArrayList<Sale>();
    private final List<Project> projects = new ArrayList<Project>();


    public Employee(int id){
        super(id);
    }
    public Employee (int id, String firstName, String lastName, int salary, Enum<Department> department, Employee manager) {
        super(id, firstName, lastName);

        this.salary = salary;
        this.department = department;
        this.manager = manager;
    }

    public boolean isManager() {
        return this.manager == null;
    }

    public Employee getManager() {
        return manager;
    }

    public Enum<Department> getDepartment() {
        return department;
    }
}
