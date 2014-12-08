package no.knowit.julekalender.luke6;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Luke6 {


    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        // Takes around 13000 milliseconds on my mac book pro
        System.out.println(solve(8000, 8000) + " Took: " + (System.currentTimeMillis() - start));
    }

    public static int solve(int n, int m) {
       return unikeProdukter(n, m).size();
    }

    public static Set<Integer> unikeProdukter(int n, int m){
        Set<Integer> products = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= m; j++){
                products.add(i * j);
            }
        }
        return products;
    }
}
