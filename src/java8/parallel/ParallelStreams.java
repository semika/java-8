package java8.parallel;

import java.util.List;

public class ParallelStreams {

    public static Long iterativeSum(List<Long> longList) {

        long result = 0;
        for (int i = 0; i <= longList.size() -1 ; i++) {
            result += longList.get(i);
        }
        return result;
    }

    public static Long parallelSum(List<Long> longList) {
        return longList.stream().parallel().reduce(0L, Long::sum);
    }
}
