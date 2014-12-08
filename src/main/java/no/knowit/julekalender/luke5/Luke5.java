package no.knowit.julekalender.luke5;

import no.knowit.julekalender.Helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import static com.google.common.collect.Sets.difference;

public class Luke5 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
    }

    public static int solve() {
        List<Integer> stortaller = stortaller();

        int min = Integer.MAX_VALUE;

        for (Integer stortall: stortaller){
            Queue<Integer> primes = Helpers.primeFactors(stortall);
            min = Math.min(min, primes.peek());
        }
        return min;
    }

    private static List<Integer> stortaller() {
        return stortallerRecursiv(0, new HashSet<Integer>());
    }

    private static List<Integer> stortallerRecursiv(int current, Set<Integer> usedNumbers){
        Set<Integer> numbersToAdd = difference(ALL, usedNumbers);

        if (usedNumbers.size() == 8) {
            List<Integer> numbers = new ArrayList<>(9);
            for (int number : numbersToAdd){
                numbers.add(current * 10 + number);
            }
            return numbers;

        } else {
            List<Integer> numbers = new ArrayList<>();
            for (int number : numbersToAdd){

                Set<Integer> usedNumbersCopy = new HashSet<>(usedNumbers);
                usedNumbersCopy.add(number);

                numbers.addAll(stortallerRecursiv(current * 10 + number, usedNumbersCopy));

            }
            return numbers;
        }
    }

    private static final Set<Integer> ALL = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
}
