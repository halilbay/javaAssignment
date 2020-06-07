#### Java Online Assignment

#Create the following OOP class hierarchy:
    • Person – general class for anyone, holding id, first name and last name.
        ◦ Employee – general class for all employees, holding the field salary and department. The deparment can only be one of the following: Production, Accounting, Sales or Marketing.
            ▪ Manager – holds a set of employees under his command.
            ▪ RegularEmployee 
                • SalesEmployee – holds a set of sales. A sale holds product name and price
                • Developer – holds a set of projects. A project holds project name, details and a state (open or closed)

Read the attachment txt files and parse the lines.

#sales.txt

**Header format:**
 
productName|price

#projects.txt

**Header format:** 

projectName|details|state

#employees.txt

**Header format:** 

id|firstname|lastname|salary|department|manager|sales|projects

**Notes:** Managers directly don’t have any projects or sales. Employees report sales and projects to their managers.
if manager column is empty, he/she is manager
if sales column is empty, there is no sale.
if projects column is empty, there is no Project.

For example, “Walter Brown” is a manager in the sales department and “Jennifer Black” reports to “Walter Brown”
**id|firstname|lastname|salary|department|manager|sales|projects**

102|walter|brown|12500|sales|-|-|-
104|jennifer|black|8000|sales|102|s1,s2,s3|-

**Questions**
* Calculate which manager has the most sales price? (hint:sum employees sales to find manager sales)
* Sort salaries for all employees in the company?
* Calculate salary expensive of the company?
* Calculate which manager has the most open projects?
* Please show the answers in the main method such as:


`static void main(String[] args){
	System.out.println(showMostSales());
    System.out.println(sortSalaries());
    System.out.println(salaryExpensive());
    System.out.println(openProjects());
        
}`