package no.knowit.julekalender.luke11;

import no.knowit.julekalender.Helpers;

import java.io.IOException;

public class Luke11 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
    }

    private static int[] primes = new int[90000];

    public static int solve() {
        generatePrimes();

        int sum;

        for (int p = 0; p < primes.length - 541; p++){
            sum = sumOfPrimes(541, p);

            if (Helpers.isPrime(sum) && sum == sumUpTo(sum, 41, p) && sum == sumUpTo(sum, 17, p) && sum == sumUpTo(sum, 7,  p)){
                return sum;
            }
        }
        throw new RuntimeException("not found");
    }

    private static void generatePrimes() {
        int i = 0;
        primes[i++] = 2;

        int numberToCheck = 3;
        while (i < primes.length){
            if (Helpers.isPrime(numberToCheck)) {
                primes[i++] = numberToCheck;
            }
            numberToCheck += 2;
        }
    }

    private static int sumUpTo(int max, int number, int start){
        int sum = 0;
        int i = start;
        while (sum < max){
            sum = sumOfPrimes(number, i);
            i ++;
        }
        return sum;
    }

    private static int sumOfPrimes(int numbers, int start){
        int part = 0;
        for (int j = 0; j < numbers; j++) {
            part += primes[start + j];
        }
        return part;

    }
}
