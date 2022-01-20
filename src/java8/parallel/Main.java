package java8.parallel;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Long> longList = getLongList(10000L);
        long startTime = System.nanoTime();

        //measureSumPerformance(ParallelStreams::iterativeSum, longList);

        measureSumPerformance(ParallelStreams::parallelSum, longList);

        long duration = (System.nanoTime() - startTime)/1_000_000;
        System.out.println(duration);
    }

    private static List<Long> getLongList(Long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).collect(Collectors.toList());
    }

    public static long measureSumPerformance(Function<List<Long>, Long> function, List<Long> longList) {
        return function.apply(longList);
    }
}
