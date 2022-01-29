/**
 * 
 */
package java8.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
	private String name;
	private Integer age;
	private String city;
	private Integer salary;
	private String sex;
	private Department department;

	public Employee(String name, Integer age) {
		this.name = name;
	}

}
