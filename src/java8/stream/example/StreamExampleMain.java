package java8.stream.example;

import java8.model.Department;
import java8.model.Employee;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamExampleMain {

	public static void main(String[] args) {

		Department account = new Department("Account", 75);
		Department hr = new Department("HR", 50);
		Department ops = new Department("OP", 25);
		Department tech = new Department("Tech", 150);
		
		List<Employee> employeeList = Arrays.asList(new  Employee("David", 32, "Matara", 2000, "Male", account),
				new  Employee("Brayan", 25, "Galle",  3000, "Male",hr),
				new  Employee("JoAnne", 45, "Negombo",  800, "Female", ops),
				new  Employee("Jake", 65, "Galle",  2500, "Male", hr),
				new  Employee("Brent", 55, "Matara",  8000, "Male", hr),
				new  Employee("Allice", 23, "Matara",  600, "Female", ops),
				new  Employee("Austin", 30, "Negombo",  9000, "Male", tech),
				new  Employee("Gerry", 29, "Matara",  2500, "Male", tech),
				new  Employee("Scote", 20, "Negombo",  2500, "Male", ops),
				new  Employee("Branden", 32, "Matara",  2500, "Male", account),
				new  Employee("Iflias", 31, "Galle",  2900, "Female", hr)); 
		
		//allMataraEmployees(employeeList);
		//allDistictDepartmentNames(employeeList);
		//departmentOver50(employeeList);
		//departmentNameCommaSeperated(employeeList);
		//findAnyEmployeeFromHR(employeeList);
		//accountDeptEmployees(employeeList);
		highestAgeEmployee(employeeList);
		//collecExamples(employeeList);
		//usingReducing(employeeList);
		//usingGroupBy(employeeList);
	}

	/**
	 * Filter records by a particular field and also sort them by a particular field.
	 * @param employeeList
	 */
	public static void allMataraEmployees(List<Employee> employeeList) {
		employeeList.stream()
					.filter(e -> e.getCity().equalsIgnoreCase("Matara"))
					.sorted(Comparator.comparing(Employee::getName))
			.forEach(e -> System.out.println(e.getName()));
	}

	/**
	 * Get data through a associated object fields.
	 * @param employeeList
	 */
	public static void allDistictDepartmentNames (List<Employee> employeeList) {
		employeeList.stream().map(e -> e.getDepartment().getDepartmentName())
			.distinct()
			.forEach(System.out::println);
	}

	/**
	 * Filter values through a field in a associted object field.
	 * @param employeeList
	 */
	public static void departmentOver50(List<Employee> employeeList) {
		employeeList.stream().map(Employee::getDepartment)
			.filter(d -> d.getNoOfEmployees() > 50).distinct()
			.forEach(d -> System.out.println(d.getDepartmentName()));
	}

	/**
	 * How to use 'reduce()' method to build a comma separated string
	 * @param employeeList
	 */
	public static void departmentNameCommaSeperated(List<Employee> employeeList) {
		String s = employeeList.stream().map(e -> e.getDepartment().getDepartmentName()).distinct()
			.sorted().reduce("", (a, b) -> (a + "," + b));
		System.out.println(s); 
	}

	/**
	 * Using anyMatch() method to search over a collection.
	 * Search for any employee who works for HR department.
	 * @param employeeList
	 */
	public static void findAnyEmployeeFromHR(List<Employee> employeeList) {
		Boolean employeeInHrPresent = employeeList.stream().anyMatch(e -> e.getDepartment().getDepartmentName().equalsIgnoreCase("HR"));
		if (employeeInHrPresent) {
			System.out.println("Found employees frm HR department"); 
		}
	}

	/**
	 * Using map() method to filter out data by a particular condition.
	 * Get list of employee names who works for 'Account' department.
	 * @param employeeList
	 */
	public static void accountDeptEmployees(List<Employee> employeeList) {
		List<String> employeeNameList = employeeList.stream()
			.filter(e -> e.getDepartment().getDepartmentName().equalsIgnoreCase("Account"))
			.map(Employee::getName).collect(Collectors.toList());
		employeeNameList.forEach(System.out::println);
	}
	
	public static void highestAgeEmployee(List<Employee> employeeList) {

		employeeList.stream().map(e -> e.getDepartment().getNoOfEmployees())
			.reduce(Integer::max)
			.ifPresent((Integer numOfEmployee) -> System.out.println(numOfEmployee));

		//Get the department having highest number of employees. Option 1
		employeeList.stream()
		            .map(Employee::getDepartment)
		            .reduce((d1, d2) -> d1.getNoOfEmployees() > d2.getNoOfEmployees() ? d1 : d2)
			.ifPresent(d -> System.out.println(d.getDepartmentName() + " :" + d.getNoOfEmployees()));
		//.map(Department::getDepartmentName).ifPresent(consumer);

		//Get the department having highest number of employees. Option 2
		employeeList.stream().map(Employee::getDepartment)
			.max(Comparator.comparing(Department::getNoOfEmployees))
			.ifPresent(d -> System.out.println(d.getDepartmentName() + " :" + d.getNoOfEmployees()));
		
		// Get the total number of employees of all departments.
		employeeList.stream().map(e -> e.getDepartment().getNoOfEmployees())
			.distinct()
			.reduce(Integer::sum)
			.ifPresent(System.out::println);
	}
	
	public static void collectExamples(List<Employee> employeeList) {
		
		//combine to list or set
		List<Employee> employee = employeeList.stream().collect(Collectors.toList());
		
		Set<Employee> employeeSet = employeeList.stream().collect(Collectors.toSet());
		
		Long totalNumOfEmployees = employeeList.stream().collect(Collectors.counting());
		
		System.out.println("Total Number of Employees :" + totalNumOfEmployees); 
		
		//Find max salary employee
		employeeList.stream()
		            .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)))
		            .ifPresent(e -> System.out.println("Max salary employee :" + e.getName()));
		
		//Find min Salary employee
		employeeList.stream()
		            .collect(Collectors.minBy(Comparator.comparingInt(Employee::getSalary)))
		            .ifPresent(e -> System.out.println("Min salary employee :" + e.getName())); 
		
		//Find total salary of all employees.
		Integer totalSalary = employeeList.stream().collect(Collectors.summingInt(Employee::getSalary)); 
		System.out.println("Totoal Salary" + totalSalary); 
		
		//Find the average salary of all employees.
		Double averageSalary = employeeList.stream().collect(Collectors.averagingInt(Employee::getSalary)); 
		System.out.println("Average Salary" + averageSalary); 
		
		//All in one
		IntSummaryStatistics salalryStat = employeeList.stream().collect(Collectors.summarizingInt(Employee::getSalary)); 
		System.out.println(salalryStat); 
		
		//All employee's names as comma seperated string
		String employeeNameStrings = employeeList.stream().map(Employee::getName).collect(Collectors.joining(", ")); 
		System.out.println(employeeNameStrings);

	}
	
	public static void usingReducing(List<Employee> employeeList) {
		Integer maxSalary = employeeList.stream().collect(Collectors.reducing(0, Employee::getSalary, Integer::max)); 
		System.out.println("Max salary " + maxSalary); 
		
		Optional<Employee> minSalary = employeeList.stream().collect(Collectors.reducing((e1, e2) -> e1.getSalary() < e2.getSalary() ? e1 :  e2));
		System.out.println("Min salary " + minSalary.get().getSalary()); 
		
		Integer _maxSalary = employeeList.stream().collect(Collectors.reducing(0, Employee::getSalary, Integer::max)); 
		System.out.println("Max salary " + _maxSalary); 
	}

	public static void usingGroupBy(List<Employee> employeeList) {
		
		//sort employees by department.
		Map<Department, List<Employee>> employeesOverDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		
		//System.out.println(employeesOverDepartment); 
		
		//group employees based on salary
		Map<String, List<Employee>> map = employeeList.stream().collect(
				Collectors.groupingBy((Employee e) -> { 
														if (e.getSalary() > 2000) {
															return "High Salary";
														} else {
															return "Low Salary";
														}
													  })); 
		
		//group employees by department name.
		Map<String, Map<String, List<Employee>>> employeesByDepartmentName = employeeList.stream().collect(
				Collectors.groupingBy((Employee e) -> { 
														return e.getDepartment().getDepartmentName();
													  }, 
									   Collectors.groupingBy((Employee e) -> { 
											return e.getSex();
									   }) ) ); 
		
		//count the number of employees in each department.
		Map<String, Long> noOfEmployeesInDepartment = employeeList.stream()
				.collect(Collectors.groupingBy((Employee e) -> { 
													return e.getDepartment().getDepartmentName();
												}, 
												Collectors.counting()));
		
		//max salary exmployee in each department
		Map<String, Employee> maxSalaryEmployeeOfDept =  employeeList.stream()
				.collect(Collectors.groupingBy((Employee e) -> {return e.getDepartment().getDepartmentName();}, 
						                       Collectors.collectingAndThen(
						                    		   Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)), 
						                    		   Optional::get) ) ); 
		
		//total salary for each department
		Map<String, Integer> totalSalaryOverDepartment = employeeList.stream()
						.collect(Collectors.groupingBy(
													(Employee e) -> {return e.getDepartment().getDepartmentName();}, 
													 Collectors.summingInt(Employee::getSalary)));  
				
		System.out.println(totalSalaryOverDepartment);
	}
}
