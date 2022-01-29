/**
 * 
 */
package java8;

import java8.model.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * @author semikasiriwardana
 *
 */
public class EmployeeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//createEmployee(Arrays.asList(34,56,43,56, 56, 56), Arrays.asList("Semika", "Nishan", "Lasantha"), (name, age) -> new Employee(name, age)); 
		List<Employee> empList = createEmployee(
			Arrays.asList(34,56,43,56, 56, 56),
			Arrays.asList("Semika", "Nishan", "Lasantha", "Jim", "Brayan", "Kelly"), Employee::new);
		empList.sort(Comparator.comparing(Employee::getAge).reversed().thenComparing(Employee::getName));
		
		for (Employee emp : empList) {
			//System.out.println(emp.getName() + ":" + emp.getAge());
 		}
		
		Predicate<Employee> elder = (emp) -> emp.getAge() > 43;
		
		List<Employee> elderEmpList = filterElders(empList, elder.and((emp) -> emp.getName().equals("Jim"))); 
		
		for (Employee emp : elderEmpList) {
			System.out.println(emp.getName() + ":" + emp.getAge());
 		}
		
		empList.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getAge().compareTo(e2.getAge()); 
			}
		}); 
		
	}

	
	public static List<Employee> createEmployee(List<Integer> ageList, List<String> nameList, BiFunction<String, Integer, Employee> biFunction) {
		
		List<Employee> empList = new ArrayList<Employee>();
		for (Integer  i = 0; i < nameList.size(); i++) {
			Employee emp = biFunction.apply(nameList.get(i), ageList.get(i)); 
			empList.add(emp);
		}
		return empList;
	}
	
	public static List<Employee> filterElders(List<Employee> empList, Predicate<Employee> p) {
		
		List<Employee> elderEmpList = new ArrayList<Employee>();
		for (Employee emp : empList) {
			if (p.test(emp)) {
				elderEmpList.add(emp); 
			}
		}
		return elderEmpList;
	}
}
 
class EmployeeComparotor implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getAge().compareTo(e2.getAge()); 
	}
}
