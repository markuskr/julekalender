package no.knowit.julekalender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Helpers {

    // Explanations:
    // http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
    public static boolean isPrime(int n) {

        if (n == 0 || n == 2 || n == 3) {
            return true;
        }

        if (n % 2 == 0){
            return false;
        }

        for(int i = 3; i < (int) Math.sqrt(n) + 1; i += 2) {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPalindrom(int number){
        return number == reverse(number);
    }

    public static int reverse(int n) {
        int reversed = 0;

        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }

        return reversed;
    }

    public static List<Integer> toList(int n){

        List<Integer> integers = new ArrayList<>();

        while (n > 0){
            integers.add(n % 10);
            n /= 10;
        }

        return integers;
    }

    public static int intLength(int n){

        int count = 0;

        while (n > 0){
            count ++;
            n /= 10;
        }

        return count;
    }

    public static boolean isPalindrom(String string){

        if (string.isEmpty()) {
            return true;
        }

        if (string.length() == 1){
            return true;
        }

        if (string.length() == 2 && string.charAt(0) == string.charAt(1)){
            return true;
        }

        if (string.charAt(0) == string.charAt(string.length() - 1)) {
            return isPalindrom(string.substring(1, string.length() - 1));
        } else {
            return false;
        }
    }

    // http://www.vogella.com/tutorials/JavaAlgorithmsPrimeFactorization/article.html
    public static Queue<Integer> primeFactors(int numbers) {
        int n = numbers;
        PriorityQueue<Integer> factors = new PriorityQueue<>(10, Collections.reverseOrder());
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
}
