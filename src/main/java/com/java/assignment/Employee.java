package com.java.assignment;

import java.util.*;

import static java.util.Comparator.comparing;

public class Employee extends Person {
    /*
    * id|firstName|lastName|salary|department|manager|sales|projects
    * */

    public static final Comparator<Employee> BY_SALARY = comparing(Employee::getSalary);

    private int salary;
    private Enum<Department> department;
    private Employee manager;
    public Set<Sale> sales = new HashSet<>();
    public Set<Project> projects = new HashSet<Project>();

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

    public void setSales(Set<Sale>sales){
        this.sales = sales;
    }

    public void setProjects(Set<Project> projects){
        this.projects = projects;
    }

    public Set<Project> getProjects(){
        return this.projects;
    }

    public Set<Sale> getSales(){
        return this.sales;
    }

    public int getSalary(){
        return this.salary;
    }

    public int getSalesPrice(){
        int sum = 0;
        if(getSales() != null && !getSales().isEmpty()){
            for  (Sale s: getSales()){
                sum += s.getPrice();
            }
        }
        return sum;
    }

    public Set<Project> projectFilterByState(ProjectState state){
        Set<Project> filteredProject = getProjects();
        if(getProjects() != null && !getProjects().isEmpty()){
            filteredProject.removeIf(p -> p.getState() != state);
        }

        return filteredProject;
    }

    public static Map<Employee, Set<Employee>> getManagerEmployeeRel(Map<Integer, Employee> employeeList){
        Map<Employee, Set<Employee>> managerEmployeeRel = new HashMap<>();
        for(Map.Entry<Integer, Employee> emp: employeeList.entrySet()){
            if(!emp.getValue().isManager()){
                // getting exist manager employee relation or create a new hashset and put in.
                Set<Employee> employeeSet = managerEmployeeRel.getOrDefault(emp.getValue().getManager(), new HashSet<>());
                employeeSet.add(emp.getValue());
                managerEmployeeRel.put(emp.getValue().getManager(), employeeSet);
            }
        }
        return managerEmployeeRel;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return getSalary() == employee.getSalary() &&
                Objects.equals(getDepartment(), employee.getDepartment()) &&
                Objects.equals(isManager(), employee.isManager()) &&
                Objects.equals(getSales(), employee.getSales()) &&
                Objects.equals(getProjects(), employee.getProjects());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSalary(), getDepartment(), isManager(), getSales(), getProjects());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
