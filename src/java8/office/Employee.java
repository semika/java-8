/**
 * 
 */
package java8.office;

public class Employee {
	
	private String name;
	
	private Integer age;
	
	private String city;
	
	private Integer salary;
	
	private String sex;
	
	private Department department;
	
	public Employee(String name, Integer age, String city, Integer salary, String sex, Department department) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.salary = salary;
		this.sex = sex;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	
}
