/**
 * 
 */
package java8.model;

/**
 * @author semikasiriwardana
 *
 */
public class Department {

	private String departmentName;
	
	private Integer noOfEmployees;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(Integer noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public Department(String departmentName, Integer noOfEmployees) {
		super();
		this.departmentName = departmentName;
		this.noOfEmployees = noOfEmployees;
	}

	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + "]";
	}
	
	
	
}
