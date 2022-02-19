package java8.general;

import java8.model.Age;
import java8.model.ImmutableStudent;

public class ImmutableMain {

    public static void main(String args[]) {

        // The state of the object which was created from a immutable
        // class, can not be changed.

        Age age = new Age(42, 2, 2);
        ImmutableStudent s1 = new ImmutableStudent("Semika", "Siriwardana", age);

        System.out.println(s1.getAge().getNumOfYears());
        s1.getAge().setNumOfYears(43);  // Age object reference is same. This changes the age of student object too.
        System.out.println(s1.getAge().getNumOfYears());

        //Wrapper class immutability

        String s2 = "semika ";
        System.out.println(s2);
        System.out.println(s2.trim());
        System.out.println(s2);

        //Wrapper class immutability
        Integer i = 10;

        System.out.println(i);
        System.out.println(i + 1);
        System.out.println(i);

    }
}
