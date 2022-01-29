package java8.lambda.example;

import java8.stream.example.model.Dish;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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
