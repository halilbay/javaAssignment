package com.java.assignment;

import java.io.IOException;
import java.util.*;
import com.java.assignment.Employee.*;
import static java.lang.Integer.parseInt;

public class Main {
	static List<Employee> employeeArrayList = new ArrayList<>();
	static Map<Integer, Employee> employeeList = new HashMap<>();

    public static void main(String[] args) throws IOException {

		// read sales and save new object to sales list
		String absPath = "/home/bay/Documents/workSpace/javaAssignment/src/main/resources/";

		// Sales part
		Map<String, Sale> saleList = new HashMap<>();
		String salesFileName = absPath + "sales.txt";
		ReadingFile fileSale = new ReadingFile(salesFileName);
		List<String[]> allSales = fileSale.getAllLines();
		for(String[] sale: allSales){
			// productName|price
			String productName = sale[0];
			int price = parseInt(sale[1]);

			saleList.put(productName, new Sale(productName, price));
		}

		// Projects part
		// read project and save new object to project list
		Map<String, Project> projectList = new HashMap<>();
		String projectFileName = absPath + "projects.txt";
		ReadingFile fileProject = new ReadingFile(projectFileName);
		List<String[]> allProject = fileProject.getAllLines();
		for (String[] project: allProject){
			// projectName|details|state
			String name = project[0];
			String details = project[1];
			ProjectState state = ProjectState.valueOf(project[2]);

			projectList.put(name, new Project(name, details, state));
		}

		// Employee part
		// read employee and save new object to employee list

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
				manager = employeeList.get(parseInt(employee[5]));
			}

			Set<Sale> sales = null;
			if (!employee[6].equals("-")) {
				sales = new HashSet<>();
				for (String s : employee[6].split(",")) {
					sales.add(saleList.get(s));
				}
			}

			Set<Project> projects = null;
			if (!employee[7].equals("-")) {
				projects = new HashSet<>();
				for (String s : employee[7].split(",")) {
					projects.add(projectList.get(s));
				}
			}
			Employee e1 = new Employee(id, firstName, lastName, salary, department, manager);
			e1.sales = sales;
			e1.projects = projects;
			employeeList.put(id, e1);
			employeeArrayList.add(e1);
		}
		Employee.getManagerEmployeeRel(employeeList);

		System.out.println(showMostSales()); // done
		System.out.println(sortSalaries()); // done
		System.out.println(salaryExpensive()); // done
		System.out.println(openProjects()); // done
    }

	private static Employee openProjects() {
    	// Calculate which manager has the most open projects?
		Map<Employee, Set<Employee>> managerEmployeeRel = Employee.getManagerEmployeeRel(employeeList);
		Map<Employee, Integer> mostOpenProject = new HashMap<>();
		for(Map.Entry<Employee, Set<Employee>> manEmpRel: managerEmployeeRel.entrySet()){
			int totalOpen = 0;
			for (Employee e: manEmpRel.getValue()){
				if(e.projectFilterByState(ProjectState.open) != null){
					totalOpen += e.projectFilterByState(ProjectState.open).size();
				}
			}
			mostOpenProject.put(manEmpRel.getKey(), totalOpen);
		}

		// getting first item of map and set as max value and the most sales manager as default
		Map.Entry<Employee, Integer> firstEntry = mostOpenProject.entrySet().iterator().next();
		int max = firstEntry.getValue();
		Employee theMost = firstEntry.getKey();
		for(Map.Entry<Employee, Integer> e: mostOpenProject.entrySet()) {
			if(e.getValue() > max){
				max = e.getValue();
				theMost = e.getKey();
			}
		}
		System.out.print("The most open project manager is: ");
		return theMost;
	}

	private static int salaryExpensive() {
    	// Calculate salary expensive of the company?
		int totalSalary = 0;
		for (Employee e: employeeArrayList){
			totalSalary += e.getSalary();
		}
		System.out.print("Total Salary is: ");
		return totalSalary;
	}

	private static List<Employee> sortSalaries() {
    	// Sort salaries for all employees in the company?
		employeeArrayList.sort(Employee.BY_SALARY.reversed());
		return employeeArrayList;
	}

	private static Employee showMostSales() {
    	// Calculate which manager has the most sales price?
		Map<Employee, Set<Employee>> managerEmployeeRel = Employee.getManagerEmployeeRel(employeeList);

		// sum all prices of sales from employees under managers
		Map<Employee, Integer> mostSale = new HashMap<>();
		for(Map.Entry<Employee, Set<Employee>> manEmpRel: managerEmployeeRel.entrySet()){
			int sum = 0;
			for (Employee e: manEmpRel.getValue()){
				sum += e.getSalesPrice();
			}
			mostSale.put(manEmpRel.getKey(), sum);
		}

		// sorted most sales

		// getting first item of map and set as max value and the most sales manager as default
		Map.Entry<Employee, Integer> firstEntry = mostSale.entrySet().iterator().next();
		int max = firstEntry.getValue();
		Employee theMost = firstEntry.getKey();
		for(Map.Entry<Employee, Integer> e: mostSale.entrySet()) {
			if(e.getValue() > max){
				max = e.getValue();
				theMost = e.getKey();
			}

		}
		System.out.print("The most sales manager is: ");
		return theMost;
    }
}
