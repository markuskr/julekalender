package no.knowit.julekalender.luke14;


import no.knowit.julekalender.Helpers;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Luke14 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
    }

    private static int MAX = 100000;

    private static Map<Integer, Integer> mapping = new HashMap<Integer, Integer>(){{
        put(0,0);
        put(1,1);
        put(8,8);
        put(6,9);
        put(9,6);
    }};

    private static List<Integer> rotations = Arrays.asList(0,1,8);

    public static int solve() {

        int counter = 0;

        System.out.println(kanLesesOppNed(916));

        for (int i = 0; i < MAX; i++){
            if (kanLesesOppNed(i)){
                System.out.println(i);
                counter ++;
            }
        }

        return counter;
    }

    private static boolean kanLesesOppNed(int n){

        int length = Helpers.intLength(n);

        if (!isFlippable(n)) {
            return false;
        }

        int flipped = 0;

        int i = 0;
        int half = (int) Math.ceil((double) length / 2);

        while (n > 0){
            int current = n % 10;

            if (i == (half -1) && length % 2 == 1 && !rotations.contains(current)){
                return false;
            }

            if (i >= half){
                flipped = 10 * flipped + mapping.get(current);
            } else {
                flipped = 10 * flipped + current;
            }

            n /= 10;
            i ++;
        }

        if (Helpers.isPalindrom(flipped) && length == Helpers.intLength(flipped)){
            return true;
        } else {
            return false;
        }
    }



    private static boolean isFlippable(int n){
        while (n > 0){
            int current = n % 10;

            if (!mapping.containsKey(current)){
                return false;
            }

            n /= 10;
        }

        return true;
    }
}
