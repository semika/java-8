/**
 * 
 */
package java8.model;

/**
 * @author semikasiriwardana
 *
 */
public class Apple {
	
	private String color;
	private Integer weight;

	public Apple() {
		super();
	}

	public Apple(Integer weight, String color) {
		super();
		this.weight = weight;
		this.color = color;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}

}
