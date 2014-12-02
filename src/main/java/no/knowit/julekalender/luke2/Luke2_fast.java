package no.knowit.julekalender.luke2;

import no.knowit.julekalender.Helpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* The idea of this implementation is to filter the numbers to check.
 With n = 9, would there we need to check 71.131.737 numbers, with a smart filter do we need to check around 194.481 (
  = 21 (number of primes below 100) ^ 4 (number of sequences without startnumber)
 */
public class Luke2_fast {

    private static Map<Integer, Boolean> primeCache = new HashMap<>();
    private static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        // Takes around 141 milliseconds on my mac book pro
        System.out.println(solve(9) + " Took: " + (System.currentTimeMillis() - start));
    }

    public static int solve(int n){

        for (int i = 11; i < 100; i += 2) {
            if (Helpers.isPrime(i)) {
                primes.add(i);
            }
        }

        int antallSekvenser = ((n - 1)/2) - 1;
        int startNummer = (int) Math.pow(10, (n - 1)) * n;

        // This function creates a list of all possible pairs
        List<Integer> possibleNumbers = possibleNumbersRecursive(antallSekvenser, startNummer);

        System.out.println(possibleNumbers.size() + " are remaining to be checked");

        for (Integer i : possibleNumbers){
            List<Integer> primeTallsekvenser = primeTallsekvenser(i);

            if (primeTallsekvenser.isEmpty() || primeTallsekvenser.size() != (n - 1)) {
                continue;
            }

            HashSet<Integer> unikeTallsekvenser = new HashSet<>(primeTallsekvenser);

            if (unikeTallsekvenser.size() != primeTallsekvenser.size()){
                continue;
            }

            // at this point we have just prime numbers in unikeTallsekvenser that are unique
            return i;
        }

        throw new RuntimeException("No Number was found");
    }

    static List<Integer> possibleNumbersRecursive(int n, int start){
        List<Integer> list = new ArrayList<>();

        if (n == 0) {
            for (Integer p : primes) {
                list.add(start + p);
            }
            return list;
        }


        for (Integer p : primes) {
            int startNumber = start + (int) Math.pow(10, n * 2) * p;
            list.addAll(possibleNumbersRecursive(n - 1, startNumber));

        }
        return list;
    }

    // This cache contains max 89 entries
    static boolean isPrimeCached (int tall){
        if (primeCache.containsKey(tall)){
            return primeCache.get(tall);
        } else {
            boolean isPrime = Helpers.isPrime(tall);
            primeCache.put(tall, isPrime);
            return isPrime;
        }
    }

    static List<Integer> primeTallsekvenser(int tall){
        List<Integer> sekvenser = new ArrayList<>(10);
        int sekvens;

        do {
            sekvens = tall % 100;
            tall /= 10;
            // Due to the combination of the primes can be still pairs of non-primes in the sequence
            if (sekvens > 9 && isPrimeCached(sekvens)) {
                sekvenser.add(sekvens);
            } else {
                break;
            }
        } while (sekvens > 0);

        return sekvenser;
    }
}
