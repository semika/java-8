/**
 * 
 */
package java8.stream;

/**
 * @author semikasiriwardana
 *
 */
public class Dish {

	private String name;
	private Boolean vegitarian;
	private Integer calaries;
	private Type type;
	
	public Dish(String name, Boolean vegitarian, Integer calaries, Type type) {
		super();
		this.name = name;
		this.vegitarian = vegitarian;
		this.calaries = calaries;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getVegitarian() {
		return vegitarian;
	}

	public void setVegitarian(Boolean vegitarian) {
		this.vegitarian = vegitarian;
	}

	public Integer getCalaries() {
		return calaries;
	}

	public void setCalaries(Integer calaries) {
		this.calaries = calaries;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", vegitarian=" + vegitarian + ", calaries=" + calaries + ", type=" + type + "]";
	}


	public enum Type { MEAT, FISH, OTHER };
}
