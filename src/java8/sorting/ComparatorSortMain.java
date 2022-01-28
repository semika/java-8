package java8.sorting;

import java8.stream.example.model.Dish;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class ComparatorSortMain {

    public static void main(String args[]) {
        List<Dish> menu = getAllDish();
        Consumer<Dish> consumer = (Dish dish) -> System.out.println(dish.getName());

        int x = 10;
        //This is annonymous class
        Comparator<Dish> comparator = new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getName().compareTo(o2.getName()); // ASC order
                //return o2.getName().compareTo(o1.getName()); // DESC order
            }
        };

        Comparator<Dish> comparator1 = (Dish o1, Dish o2) -> o1.getName().compareTo(o2.getName());

        //sort the object list
        Collections.sort(menu, comparator1);

        //print
        menu.stream().forEach(consumer);
    }


    private static List<Dish> getAllDish() {
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
        return menu;
    }
}
