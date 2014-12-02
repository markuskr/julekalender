package no.knowit.julekalender.luke1;

import no.knowit.julekalender.Helpers;

public class Luke1 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // Takes around 77 milliseconds on my mac book pro
        System.out.println(solve(1000000) + " Took: " + (System.currentTimeMillis() - start));
    }

    public static int solve(int max){
        int count = 0;

        for (int i = 1; i <= max; i++){
            if (Helpers.isPalindrom(Integer.toString(i)) && Helpers.isPalindrom(Integer.toOctalString(i))){
                count ++;
            }
        }
        return count;
    }
}
