package java8.model;

import lombok.Getter;

@Getter
// by making class final, we make sure, this class can not be extended.
public final class ImmutableStudent {

    //By making fields final, this makes sure, only onces
    //values for these fields can be set. that is through a constructor.
    private final String firstName;
    private final String lastName;
    private final Age age;

    public ImmutableStudent(String firstName, String lastName, Age age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Age getAge() {
        return Age.of(this.age);
    }


    //To make class immutable
    // (1) Make the class final first
    // (2) Make all the fieds final and add the all args constructor
    // (3) Do not provide setter methods
    // (4) If object reference is returned from a getter method, do not return the original, return a copy
}
