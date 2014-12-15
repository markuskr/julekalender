package no.knowit.julekalender.luke8;


import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Luke8 {


    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        System.out.println(solve(10000) + " Took: " + (System.currentTimeMillis() - start));
    }

    public static String solve(int max) {

         return IntStream.of(2, 3, 5, 7, 11, 13, 17)
                .map(i -> (int) Math.pow(2, i - 1) * (int) (Math.pow(2, i) - 1))
                .filter(n -> n < max && n > 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
