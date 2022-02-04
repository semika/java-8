/**
 * 
 */
package java8.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author semikasiriwardana
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Circle implements Shape {

	private Integer radious;

	@Override
	public Integer area() {
		return (22/7) * this.radious * this.radious;
	}
	
}
