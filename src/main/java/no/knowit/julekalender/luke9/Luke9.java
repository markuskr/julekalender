package no.knowit.julekalender.luke9;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Luke9 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
    }

    public static int solve() {
        List<Integer> stortaller = stortaller();

        int min = Integer.MAX_VALUE;

        for (Integer stortall: stortaller){
            min = Math.min(min, stortall);
        }
        return min;
    }


    private static List<Integer> stortaller() {
        return stortallerRecursiv(0, 0, new ArrayList<>());
    }

    private static List<Integer> stortallerRecursiv(int tall1, int tall2, List<Integer> usedNumbers){

        List<Integer> numbersToAdd = diff(ALL, usedNumbers);
        if (usedNumbers.size() >= 6) {
            int sum = tall1 + tall2;

            List<Integer> numbers = new ArrayList<>(1);
            if  (sum > 1000 && containsAll(numbersToAdd, sum)){
                numbers.add(Math.min(tall1, tall2));
            }
            return numbers;

        } else {
            List<Integer> numbers = new ArrayList<>();
            for (int number : numbersToAdd){
                List<Integer> usedNumbersCopy = new ArrayList<>(usedNumbers);
                usedNumbersCopy.add(number);
                if (usedNumbers.size() < 3) {
                    numbers.addAll(stortallerRecursiv(10 * tall1 + number, tall2, usedNumbersCopy));
                } else if (usedNumbers.size() <= 6) {
                    numbers.addAll(stortallerRecursiv(tall1, 10 * tall2 + number, usedNumbersCopy));
                }
            }
            return numbers;
        }
    }

    private static final boolean containsAll(List<Integer> numbers, int number){
        do {
            int current = number % 10;
            if (!numbers.contains(current)){
                return false;
            } else {
                numbers.remove(new Integer(current));
            }
            number /= 10;
        } while (number > 0);

        return true;
    }

    private static final List<Integer> diff(List<Integer> list1, List<Integer> list2){
       return  list1.stream().filter(i -> !list2.contains(i)).collect(Collectors.toList());
    }

    private static final List<Integer> ALL = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
}
