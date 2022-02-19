package java8.general;

import java8.model.Dish;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TopTalTaskOne {

    public static void main(String args[]) {
        String message = "The quick brown fox jumps over the lazy dog";
        //String messagea = solution(message, 39);
        //System.out.print(messagea);
        int[] people = {1,4,1};
        int[] seats = {1,5 ,1};
        System.out.print(solution(people, seats));
    }

    public static String solution(String message, int k) {
        // write your code in Java SE 8
        String[] wordArray = message.split("\\s");
        int numOfSpaces = wordArray.length - 1;
        List<String> wordList = new ArrayList<>();

        int totalWordOnlyLenth = 0;

        for (String word: wordArray) {
            totalWordOnlyLenth = totalWordOnlyLenth + word.length();
            int lenthAfterCurrentWord = totalWordOnlyLenth + numOfSpaces;

            if (lenthAfterCurrentWord <= k) {
                wordList.add(word.trim());
            }
        }

        return wordList.stream().collect(Collectors.joining(" "));
    }

    public static int solution(int[] people, int[] seats) {

        int totalSeats = 0;
        for (int i = 0; i < seats.length; i++) {
            totalSeats = totalSeats + seats[i];
        }

        int totalPeople = 0;
        for(int i = 0; i < people.length; i++) {
            totalPeople = totalPeople + people[1];
        }

        int reducedCars = 0;

        int extraSeats = totalSeats - totalPeople;

        for (int i = 0; i < seats.length; i++) {
            if (extraSeats == seats[i]) {
                reducedCars++;
                extraSeats = extraSeats - seats[i];
            }
        }

        return seats.length - reducedCars;
    }
}
