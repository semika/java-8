package java8.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Age {
    private int numOfYears;
    private int numOfMonths;
    private int numOfDays;

    public static Age of(Age age) {
        Age ageNew = new Age();
        ageNew.setNumOfYears(age.getNumOfYears());
        ageNew.setNumOfMonths(age.getNumOfMonths());
        ageNew.setNumOfDays(age.getNumOfDays());

        return ageNew;
    }
}
