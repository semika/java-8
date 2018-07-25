/**
 * 
 */
package java8;

/**
 * @author semikasiriwardana
 *
 */
public class Square implements Shape {

	private Integer size;
	
	public Square() {
		super();
	}

	public Square(Integer size) {
		super();
		this.size = size;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public Integer area() {
		return null;
	}
	
}
