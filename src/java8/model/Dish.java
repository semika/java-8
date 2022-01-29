/**
 * 
 */
package java8.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author semikasiriwardana
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dish {

	private String name;
	private Boolean vegitarian;
	private Integer calaries;
	private DishType type;

}
