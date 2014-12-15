package no.knowit.julekalender.luke13;

import no.knowit.julekalender.Helpers;

import java.io.IOException;

public class Luke13 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
    }

    private static int MAX = 1000;

    public static int solve() {

        int counter = 0;

        for (int i = 11; i <= MAX; i += 2) {
           if (Helpers.isPrime(i)){
               int reversed = Helpers.reverse(i);
               counter = (Helpers.isPrime(reversed) && reversed != i) ? counter + 1 : counter;
           }
        }
        return counter;
    }
}
