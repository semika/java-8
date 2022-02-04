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
public class Square implements Shape {

	private Integer size;
	
	@Override
	public Integer area() {
		return this.size * this.size;
	}
	
}
