/**
 * 
 */
package java8;

/**
 * @author semikasiriwardana
 *
 */
public class Circle implements Shape{

	private Integer radious;
	
	public Circle() {
		super();
	}

	public Circle(Integer radious) {
		super();
		this.radious = radious;
	}

	public Integer getRadious() {
		return radious;
	}

	public void setRadious(Integer radious) {
		this.radious = radious;
	}

	@Override
	public Integer area() {
		return null;
	}
	
}
