package java8.lambda.example;

import java8.model.Dish;
import java8.model.DishType;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * How to replace old annonymous class with lambda exprestion.
 */
public class ComparatorSortMain {

    public static void main(String args[]) {
        List<Dish> menu = getAllDish();

        //This is annonymous class -> legecy comparator
        Comparator<Dish> comparator = new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getName().compareTo(o2.getName()); // ASC order
                //return o2.getName().compareTo(o1.getName()); // DESC order
            }
        };

        //This is lambda style comparator
        Comparator<Dish> comparator1 = (Dish o1, Dish o2) -> o1.getName().compareTo(o2.getName());

        // As explicit function declaration
        Function<Dish, String> getNameFunction1 = (Dish dish) -> {
            return dish.getName();
        };

        Function<Dish, String> getNameFunction2 = (Dish dish) -> dish.getName();

        Comparator<Dish> comparator2 = Comparator.comparing(getNameFunction1); // Passing as a function

        Comparator<Dish> comparator3 = Comparator.comparing(Dish::getName); // Passing as method reference

        //sort the object list
        System.out.println("----------------------------------");
        Collections.sort(menu, comparator3);

        //print by using a consumer
        Consumer<Dish> consumer = (Dish dish) -> System.out.println(dish.getName());
        menu.stream().forEach(consumer);
    }


    private static List<Dish> getAllDish() {
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
        return menu;
    }
}
