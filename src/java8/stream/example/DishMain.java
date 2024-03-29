/**
 * 
 */
package java8.stream.example;

import java8.model.CaloryLevel;
import java8.model.Dish;
import java8.model.DishType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author semikasiriwardana
 *
 */
public class DishMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//List<Dish> menu = new ArrayList<Dish>();
		
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, DishType.MEAT),
				new Dish("beef", false, 700, DishType.MEAT),
				new Dish("chicken", false, 400, DishType.MEAT),
				new Dish("french fries", true, 530, DishType.OTHER),
				new Dish("rice", true, 350, DishType.OTHER),
				new Dish("season fruit", true, 120, DishType.OTHER),
				new Dish("pizza", true, 550, DishType.OTHER),
				new Dish("prawns", false, 300, DishType.FISH),
				new Dish("salmon", false, 450, DishType.FISH),
				new Dish("salmon", false, 450, DishType.FISH));
		
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
		
		//mathing(menu);
		
		//finding(menu);
		
		//reduceTest(menu);
		
		//numberRange();

		//groupDishByCaloriAmountLegacyApproch(menu);

		//groupDishByCaloriAmountNewApproch(menu);

		//groupDishesByType(menu);
		
		//partition(menu);
		
		//primeNumbers(20);

		//predicateExample(menu);

		//functionExample(menu);

		findMaxCalariesDish(menu);
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

	public static void predicateExample(List<Dish> menu) {

		Predicate<Dish> dishPredicate = (Dish dish) -> {
			return dish.getVegitarian();
		};

		Predicate<Dish> dishPredicate1 = (Dish dish) -> dish.getVegitarian();

		Predicate<Dish> dishPredicate2 = Dish::getVegitarian;

		List<Dish> vegiList = menu.stream().filter(dishPredicate2).collect(Collectors.toList());
		vegiList.forEach((Dish dish) -> {
			System.out.println(dish.getName());
		});
	}

	public static void functionExample(List<Dish> menu) {

		Function<Dish, String> function = (Dish dish) -> {
			return dish.getName();
		};

		Function<Dish, String> function1 = (Dish dish) -> dish.getName();

		Function<Dish, String> function2 = Dish::getName;

		List<String> dishNameList = menu.stream().map(function2).collect(Collectors.toList());
		dishNameList.forEach((String s) -> System.out.println(s));
	}

	public static void makeVegitarianMenu(List<Dish> menu) {
		List<Dish> vegitarianDishes = menu.stream().filter(Dish::getVegitarian).collect(Collectors.toList());
		
		menu.stream().filter(d -> d.getType() == DishType.MEAT).collect(Collectors.toList()).forEach(System.out :: println);
		
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
		
		Optional<Dish> dishOptional = menu.stream().filter(d -> d.getType() == DishType.MEAT).findAny();
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
		
		Long noOfDishesInMenu = menu.stream().count();
		
		//Using collectors
		
		noOfDishesInMenu = menu.stream().collect(Collectors.counting()); 
		Optional<Dish> maxCalariedDish = menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalaries)));  
		
		maxCalariedDish = menu.stream().collect(Collectors.reducing( (d1, d2) -> d1.getCalaries() > d2.getCalaries() ? d1 : d2));
		
		Optional<Dish> minCalariedDish = menu.stream().collect(Collectors.minBy(Comparator.comparing(Dish::getCalaries)));   
		
		Integer totoalCalaries = menu.stream().collect(Collectors.summingInt(Dish::getCalaries)); 
		totoalCalaries = menu.stream().collect(Collectors.reducing(0, Dish::getCalaries, (i, j) -> i + j)); 
		totoalCalaries = menu.stream().mapToInt(Dish::getCalaries).sum();
		totoalCalaries = menu.stream().map(Dish::getCalaries).reduce(Integer::sum).get();
		
		
		Double averageCalaries = menu.stream().collect(Collectors.averagingInt(Dish::getCalaries)); 
		IntSummaryStatistics calarysummary = menu.stream().collect(Collectors.summarizingInt(Dish::getCalaries)); 
		String dishNames = menu.stream().map(Dish::getName).collect(Collectors.joining(","));  
		 
		System.out.println("Number of Dishes in the menu " + noOfDishesInMenu); 
		System.out.println("Max Calaries " + maxCalariedDish.get().getCalaries()); 
		System.out.println("Min Calaries " + minCalariedDish.get().getCalaries()); 
		System.out.println("Totoal Calaries " + totoalCalaries); 
		System.out.println("Averageing Calaries " + averageCalaries); 
		System.out.println("Summary " + calarysummary);
		System.out.println("Dish Names " + dishNames); 
		
		//System.out.println(totoalCalries); 
	}
	
	public static void numberRange() {
		IntStream.rangeClosed(1, 100).filter(n -> n%2 == 0).forEach(System.out::println);  
	}
	
	public static void groupDishesByType(List<Dish> menu) {
		
		//grouping by type
		Map<DishType, List<Dish>> dishOverType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
		//System.out.println(dishOverType);
		
		Map<DishType, Long> countByEachType = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
		//System.out.println(countByEachType);  
		
		Map<DishType, Dish> maxCalariesByType = menu.stream().collect(Collectors.groupingBy(
				Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalaries)), Optional::get)));
		//System.out.println(maxCalariesByType); 
		
		//Max calories for each type
		Map<DishType, Optional<Dish>> ss = menu.stream().collect(Collectors.groupingBy(Dish::getType,
				                                                                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalaries))));   
		System.out.println(ss); 
		
		Map<DishType, Integer> totalCalriesOverType = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalaries)));
		//System.out.println(totalCalriesOverType); 
		
		Map<Boolean, List<Dish>> s = menu.stream().collect(Collectors.partitioningBy(d -> d.getCalaries() > 1000));
		
		//System.out.println(s); 
		
		//grouping by calaric level
		Map<CaloryLevel, List<Dish>> dishesOverCalaricLevel = menu.stream().collect(Collectors.groupingBy((Dish d) -> {
				if (d.getCalaries() <= 400) {
					return CaloryLevel.DIET;
				} else if (d.getCalaries() <= 700) {
					return CaloryLevel.NORMAL;
				} else  
					return CaloryLevel.FAT;
				}
		));  
		
		//second level grouping
		Map<DishType, Map<CaloryLevel, List<Dish>>> dishesOverCalaricLevel2 = menu.stream()
				.collect(Collectors.groupingBy(Dish::getType,  
						 				Collectors.groupingBy((Dish d) -> {  
													if (d.getCalaries() <= 400) {
														return CaloryLevel.DIET;
													} else if (d.getCalaries() <= 700) {
														return CaloryLevel.NORMAL;
													} else  
														return CaloryLevel.FAT;
													}
						 						)
						 			));  
		
		Map<DishType, Set<CaloryLevel>> calaricLevelOverType = menu.stream()
																		  .collect(Collectors.groupingBy(Dish::getType, 
																				                         Collectors.mapping( (Dish d) -> {
																												if (d.getCalaries() <= 400) {
																													return CaloryLevel.DIET;
																												} else if (d.getCalaries() <= 700) {
																													return CaloryLevel.NORMAL;
																												} else { 
																													return CaloryLevel.FAT;
																												}
																				                         	}    , Collectors.toSet()))); 
		//System.out.println(calaricLevelOverType); 
		
		//System.out.println(dishesOverCalaricLevel2); 
		
	}

	public static void groupDishByCaloriAmountLegacyApproch(List<Dish> menu) {

		Map<CaloryLevel, List<Dish>> dishOverCaloryLevel = new HashMap<CaloryLevel, List<Dish>>();

		for(CaloryLevel caloryLevel : CaloryLevel.values()) {
			dishOverCaloryLevel.put(caloryLevel, new ArrayList<Dish>());
		}

		for(Dish dish : menu) {
			if (dish.getCalaries() <= 400) {
				dishOverCaloryLevel.get(CaloryLevel.DIET).add(dish);
			} else if (dish.getCalaries() <= 700) {
				dishOverCaloryLevel.get(CaloryLevel.NORMAL).add(dish);
			} else {
				dishOverCaloryLevel.get(CaloryLevel.FAT).add(dish);
			}
		}
	}

	public static void groupDishByCaloriAmountNewApproch(List<Dish> menu) {

		Map<CaloryLevel, List<Dish>> dishOverCaloryLevel = menu.stream().collect(Collectors.groupingBy((Dish d) -> {
				if (d.getCalaries() <= 400) {
					return CaloryLevel.DIET;
				} else if (d.getCalaries() <= 700) {
					return CaloryLevel.NORMAL;
				} else
					return CaloryLevel.FAT;
			}
		));

		Map<CaloryLevel, List<Dish>> dishOverCaloryLevel1 = menu.stream().collect(Collectors.groupingBy(Dish::getCaloryLevel));

		System.out.println(dishOverCaloryLevel1);
	}

	public static void partition(List<Dish> menu) {
		
		Map<Boolean, List<Dish>> dishTypeMap = menu.stream().collect(Collectors.partitioningBy(Dish::getVegitarian));  
	//	System.out.println(dishTypeMap.get(true)); 
		
		List<Dish> vegitatianDish = menu.stream().filter(Dish::getVegitarian).collect(Collectors.toList());  
	//	System.out.println(vegitatianDish); 
		
		List<Dish> nonVegitarianDish = menu.stream().filter(  d -> !d.getVegitarian() ).collect(Collectors.toList()); 
	//	System.out.println(nonVegitarianDish); 
		
		
		Map<Boolean, Map<DishType, List<Dish>>> x = menu.stream().collect(Collectors.partitioningBy(Dish::getVegitarian, Collectors.groupingBy(Dish::getType)));
	//	System.out.print(x); 
		
		Map<Boolean, Dish> xx = menu.stream()
			.collect(Collectors.partitioningBy(Dish::getVegitarian, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalaries)), Optional::get))); 
		System.out.println(xx); 
		
	}
	
	public static void primeNumbers(int n) {
		//IntStream.range(1, n).forEach( i -> );
		
		for (int i = 1; i <= n; i++) {
			boolean isPrime = true;
			
			for (int j = 2; j <= i; j++) {
				if (i != j && i % j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				//System.out.println(i);
			}
		}
		
		isPrime(4);
	}
	
	public static void isPrime(int n) {
		Boolean isPrime = IntStream.range(2, n).noneMatch(i -> n % i == 0);
		if (isPrime) {
			System.out.println(n + " is  a prime number");
		} else {
			System.out.println(n + " is not a prime number");
		}
	}

	public static void findMaxCalariesDish(List<Dish> menu) {
		Dish highCalaryDish = menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalaries))).get();
		System.out.println(highCalaryDish);
	}
}
