package java8.office;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OfficeMain {

	public static void main(String[] args) {

		Department account = new Department("Account", 75); 
		Department hr = new Department("HR", 50);
		Department ops = new Department("OP", 25);
		Department tech = new Department("Tech", 150);
		
		List<Employee> employeeList = Arrays.asList(new  Employee("David", 32, "Matara", account), 
				new  Employee("Brayan", 25, "Galle", hr),
				new  Employee("JoAnne", 45, "Negombo", ops),
				new  Employee("Jake", 65, "Galle", hr),
				new  Employee("Brent", 55, "Matara", hr),
				new  Employee("Allice", 23, "Matara", ops),
				new  Employee("Austin", 30, "Negombo", tech),
				new  Employee("Gerry", 29, "Matara", tech),
				new  Employee("Scote", 20, "Negombo", ops),
				new  Employee("Branden", 32, "Matara", account),
				new  Employee("Iflias", 31, "Galle", hr)); 
		
		//allMataraEmployees(employeeList);
		//allDistictDepartmentNames(employeeList);
		//departmentOver50(employeeList);
		//departmentNameCommaSeperated(employeeList);
		//findAnyEmployeeFromHR(employeeList);
		//accountDeptEmployees(employeeList);
		highestAgeEmployee(employeeList);
		
	}
	
	public static void allMataraEmployees(List<Employee> employeeList) {
		employeeList.stream()
					.filter(e -> e.getCity().equalsIgnoreCase("Matara"))
					.sorted(Comparator.comparing(Employee::getName)).forEach(e -> System.out.println(e.getName()));  
	}
	
	public static void allDistictDepartmentNames (List<Employee> employeeList) {
		employeeList.stream().map(e -> e.getDepartment().getDepartmentName()).distinct().forEach(System.out::println); 
	}
	
	public static void departmentOver50(List<Employee> employeeList) {
		employeeList.stream().map(Employee::getDepartment).filter(d -> d.getNoOfEmployees() > 50).distinct().forEach(d -> System.out.println(d.getDepartmentName()));
	}
	
	public static void departmentNameCommaSeperated(List<Employee> employeeList) {
		String s = employeeList.stream().map(e -> e.getDepartment().getDepartmentName()).distinct().sorted().reduce("", (a, b) -> (a + "," + b)); 
		System.out.println(s); 
	}
	
	public static void findAnyEmployeeFromHR(List<Employee> employeeList) {
		if (employeeList.stream().anyMatch(e -> e.getDepartment().getDepartmentName().equalsIgnoreCase("HR"))) {
			System.out.println("Found employees frm HR department"); 
		}
	}
	
	public static void accountDeptEmployees(List<Employee> employeeList) {
		employeeList.stream().filter(e -> e.getDepartment().getDepartmentName().equalsIgnoreCase("Account")).map(Employee::getName).forEach(System.out::println);
	}
	
	public static void highestAgeEmployee(List<Employee> employeeList) {
		//employeeList.stream().map(e -> e.getDepartment().getNoOfEmployees()).reduce(Integer::max).ifPresent(System.out::print);  
		
		employeeList.stream()
		            .map(Employee::getDepartment)
		            .reduce( (d1, d2) -> d1.getNoOfEmployees() > d2.getNoOfEmployees() ? d1 : d2).ifPresent(d -> System.out.println(d.getDepartmentName()));  //.map(Department::getDepartmentName).ifPresent(consumer);
	
		employeeList.stream().map(Employee::getDepartment).max(Comparator.comparing(Department::getNoOfEmployees)).ifPresent(d -> System.out.println(d.getDepartmentName()));
		
		
		employeeList.stream().map(e -> e.getDepartment().getNoOfEmployees()).distinct().reduce(Integer::sum).ifPresent(System.out::println);  
	}

}
