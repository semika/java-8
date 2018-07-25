/**
 * 
 */
package java8.stream;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TooManyListenersException;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java8.stream.Dish.Type;

/**
 * @author semikasiriwardana
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//List<Dish> menu = new ArrayList<Dish>();
		
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT), 
				new Dish("beef", false, 700, Dish.Type.MEAT), 
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), 
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), 
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), 
				new Dish("salmon", false, 450, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));
		
		//menu.stream().map(Dish::getName).forEach(System.out::println); 
		
		//filterHightCalaris(menu); 
		
		Set<String> stringSet =  menu.stream().map(Dish::getName).collect(Collectors.toCollection(TreeSet::new));
		
		String nameString = menu.stream().map(Dish::getName).collect(Collectors.joining(",")); 
		
		Integer totoalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalaries));
		 
		//group Dish by calaries.
		Map<Integer, List<Dish>> map = menu.stream().collect(Collectors.groupingBy(Dish::getCalaries)); 
		
		//System.out.println(map.toString()); 
		
		//consumedStream(menu);
		
		//makeVegitarianMenu(menu); 
		
		//mapDishName(menu); 
		
		//flatMapTest(menu);
		
		mathing(menu);
		
		//finding(menu);
		
		//reduceTest(menu);
		
		//numberRange();
	}
	
	public static void filterHightCalaris(List<Dish> menu) {
		List<String> threeHighCalaricDishNames = menu.stream().filter(d -> d.getCalaries() > 300)
													 		  .map(Dish::getName)
													 		  .limit(3)
													 		  .skip(1) 
													 		  .collect(Collectors.toList());
		threeHighCalaricDishNames.forEach(System.out::println); 
	}
	
	public static void consumedStream(List<Dish> menu) {
		
		Stream<Dish> stream = menu.stream(); 
		
		stream.forEach(d -> System.out.println(d.getName()));  

		stream.forEach(System.out::println);  
		
	}

	public static void makeVegitarianMenu(List<Dish> menu) {
		List<Dish> vegitarianDishes = menu.stream().filter(Dish::getVegitarian).collect(Collectors.toList());
		
		menu.stream().filter(d -> d.getType() == Dish.Type.MEAT).collect(Collectors.toList()).forEach(System.out :: println); 
		
		//vegitarianDishes.forEach(d -> System.out.println(d.getName())); 
		
		//System.out.println(vegitarianDishes); 
		
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5 ,6,7,8,9,4,2);
		
		List<Integer> evenList = integerList.stream().filter(i -> i%2 ==0).distinct().collect(Collectors.toList()); 
		
		//evenList.forEach(System.out::println);
		
		//System.out.println(evenList); 		
	}
	
	public static void mapDishName(List<Dish> menu) {
		List<Integer> intList = menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
		System.out.println(intList); 
	}
	
	public static void flatMapTest(List<Dish> menu) {
		List<String> result = menu.stream().map(Dish::getName).map(name -> name.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());  
		
		//List<String[]> nameArray = menu.stream().map(Dish::getName).map(name -> name.split("")).collect(Collectors.toList()); 
		//Arrays.stream(nameArray);
		
		System.out.println(result); 
	}
	
	public static void mathing(List<Dish> menu) {
		if (menu.stream().anyMatch(Dish::getVegitarian)) { 
			System.out.println("Found vegitarion menu..!");  
		}
		
		if (menu.stream().allMatch(d -> d.getCalaries() < 1000)) { 
			System.out.println("All healthy");  
		}
		
		if (menu.stream().noneMatch(d -> d.getCalaries() >= 1000)) { 
			System.out.println("All healthy"); 
		}
		
		//Optional<Dish> dishOptional = menu.stream().filter(Dish::getVegitarian).findAny(); 
		
		Optional<Dish> dishOptional = menu.stream().filter(d -> d.getType() == Dish.Type.MEAT).findAny(); 
		if (dishOptional.isPresent()) {
			System.out.println(dishOptional.get().getName()); 
		}
		
		 
	}
	
	public static void finding (List<Dish> menu) {
		
		List<Dish> vegitarianDishes = menu.stream().filter(Dish::getVegitarian).collect(Collectors.toList());
		
		menu.stream().filter(d -> d.getVegitarian()).collect(Collectors.toList()); 
		
		menu.stream().filter(Dish::getVegitarian).findAny().ifPresent(d -> System.out.println(d.getName())); 
		
		menu.stream().filter(d -> d.getCalaries() % 200 == 0).findFirst().ifPresent(d->System.out.println(d.getName()));  
	}
	
	public static void reduceTest(List<Dish> menu) {
		Integer totoalCalries = menu.stream().map(Dish::getCalaries).reduce(0, (a, b) -> a + b);
		
		menu.stream().map(Dish::getCalaries).reduce(Integer::sum).ifPresent(d -> System.out.println("Totoal Calaries " + d)); 
		int totalCalaries = menu.stream().mapToInt(Dish::getCalaries).sum();
		System.out.println("Total Calaries : " + totalCalaries); 
		
		menu.stream().map(Dish::getCalaries).reduce(Integer::max).ifPresent(d->System.out.println("Max Calaries " + d));
		OptionalInt optInt = menu.stream().mapToInt(Dish::getCalaries).max();
		int maxCalaries = optInt.orElse(0); 
		System.out.println("Max Calaries -->" + maxCalaries); 
		
		menu.stream().map(Dish::getCalaries).reduce(Integer::min).ifPresent(d->System.out.println("Min Calaries " + d)); 
		
		//System.out.println(totoalCalries); 
	}
	
	public static void numberRange() {
		IntStream.rangeClosed(1, 100).filter(n -> n%2 == 0).forEach(System.out::println);  
	}
}
