package java8.lambda.example;

import java8.model.Dish;
import java8.model.DishType;
import java.util.Arrays;
import java.util.List;

public class ConditionalResolverMain {

    //Print Dish calaries having above 500, as "HIGH" or else, "LOW"

    public static void main(String args[]) {

        List<Dish> menu = getAllDish();

        ConditionalResolver.of(!menu.isEmpty())
            .ifTrue(() -> {
                menu.forEach((Dish dish) -> {
                    ConditionalResolver.<Dish>of(dish.getCalaries() >= 500)
                        .ifTrue(() -> {
                            System.out.println("Total Dish Calaries = " + dish.getCalaries() + ", HIGH");
                        })
                        .ifFalse(() -> {
                            System.out.println("Total Dish Calaries = " + dish.getCalaries() + ", LOW");
                        }).execute();
                });
            })
            .ifFalse(() -> {
                System.out.println("Empty List");
            })
            .execute();

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
