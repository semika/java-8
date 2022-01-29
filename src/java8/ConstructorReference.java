/**
 * 
 */
package java8;

import java8.model.Apple;
import java8.model.Circle;
import java8.model.Shape;
import java8.model.Square;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author semikasiriwardana
 *
 */
public class ConstructorReference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> weightList = Arrays.asList(3,4,6,4,4);
		
		Supplier<Apple> c1 = Apple::new;
		
		Supplier<Apple> c2 = () -> new Apple();
		
		Apple apple1 = c1.get();
		
		Apple apple2 = c2.get();
		
		BiFunction<Integer, String, Apple> f1 = Apple::new;
		Apple apple3 = f1.apply(10, "red"); 
		
		BiFunction<Integer, String, Apple> f2 = (weight, color) -> new Apple(weight, color);
		Apple apple4 = f2.apply(10, "green");  
		
		List<Apple> appleList = map(Arrays.asList(5,3,6,7), Arrays.asList("green", "red", "red", "green"), Apple :: new);
		
		Predicate<Apple> greenApple = (a) -> a.getColor().equalsIgnoreCase("green");
		
		
		List<Apple> greenAppleList = new ArrayList<Apple>();
		
		for (Apple appl : appleList) {
			if (greenApple.and((a) -> a.getWeight() == 5).test(appl)) {
				greenAppleList.add(appl);  
			}
		}
		
		//System.out.println(greenAppleList.toString());
		 
		List<Shape> circleList = createShape(Arrays.asList(5,6,7,8), Circle::new);
		
		List<Shape> squareList = createShape(Arrays.asList(5,6,7,8), Square::new);
		
		Function<Integer, Integer> add = (x) -> x +1; 
		Function<Integer, Integer> multiply = (x) -> x*2;
		
		Function<Integer, Integer> result = add.andThen(multiply);
		System.out.println(result.apply(10));  
		
		Function<Integer, Integer> result1 = add.compose(multiply);
		System.out.println(result1.apply(10));
		
		
	}

	
	public static List<Apple> map(List<Integer> weightList, List<String> colorList, BiFunction<Integer, String, Apple> f) {
		List<Apple> appleList = new ArrayList<Apple>(weightList.size());
		
		for (int i = 0; i < weightList.size(); i++) {
			appleList.add(f.apply(weightList.get(i), colorList.get(i)));
		}
		
		return appleList;
	}
	
	public static List<Shape> createShape(List<Integer> length, Function<Integer, Shape> f) {
		List<Shape> shapeList = new ArrayList<Shape>(); 
		for (Integer i : length) {
			shapeList.add(f.apply(i)); 
		}
		return shapeList;
	}
	
	public static void composeFunction() {
		
	}
}
