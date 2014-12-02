package no.knowit.julekalender.luke2;

import no.knowit.julekalender.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Luke2 {

    private static Map<Integer, Boolean> primeCache = new HashMap<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // Takes around 1,5 seconds on my mac book pro
        System.out.println(solve(9) + " Took: " + (System.currentTimeMillis() - start));
    }

    public static int solve(int n){

        int start = (n * (int) Math.pow(10, n - 1)) + 1;
        int maxNumber =  (n + 1) * (int) Math.pow(10, n - 1);

        // We are just interested in odd numbers, since no sequence that ends with an even number can be prime
        for (int i = start; i < maxNumber; i += 2){

            List<Integer> primeTallsekvenser = primeTallsekvenser(i);

            if (primeTallsekvenser.isEmpty() || primeTallsekvenser.size() != (n - 1)) {
                continue;
            }

            HashSet<Integer> unikeTallsekvenser = new HashSet<>(primeTallsekvenser);

            if (unikeTallsekvenser.size() != primeTallsekvenser.size()){
                continue;
            }

            // at this point we have just prime number in unikeTallsekvenser that are unique
            return i;
        }

        throw new RuntimeException("No Number was found");
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
        List<Integer> sekvenser = new ArrayList<>();
        int sekvens;

        do {
            sekvens = sekvensAtLastIndex(tall);

            if (sekvens > 9 && isPrimeCached(sekvens)) {
                sekvenser.add(sekvens);
            } else {
                break;
            }
            tall /= 10;
        } while (sekvens > 0);

        return sekvenser;
    }

    static int sekvensAtLastIndex(int tall){
        return tall % 100;
    }
}
