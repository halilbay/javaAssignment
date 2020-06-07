package com.java.assignment;

import java.io.IOException;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

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
		System.out.println(saleList);

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
		System.out.println(projectList);

		// Employee part
		// read employee and save new object to employee list
		Map<Integer, Employee> employeeList = new HashMap<>();
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

			List<Sale> sales = null;
			if (!employee[6].equals("-")) {
				sales = new ArrayList<>();
				for (String s : employee[6].split(",")) {
					sales.add(saleList.get(s));
				}
			}

			List<Project> projects = null;
			if (!employee[7].equals("-")) {
				projects = new ArrayList<>();
				for (String s : employee[7].split(",")) {
					projects.add(projectList.get(s));
				}
			}
			Employee e1 = new Employee(id, firstName, lastName, salary, department, manager);
			e1.sales = sales;
			e1.projects = projects;
			employeeList.put(id, e1);
		}

		System.out.println(employeeList);

		// TODO fill that functions
		System.out.println(showMostSales());
		System.out.println(sortSalaries());
		System.out.println(salaryExpensive());
		System.out.println(openProjects());
    }

	private static String[] openProjects() {
		return null;
	}

	private static int salaryExpensive() {
		return 0;
	}

	private static int[] sortSalaries() {
		return null;
	}

	private static Employee[] showMostSales() {
		return null;
    }

	public static int getValue(){
    	return 5;
	}

}
