package no.knowit.julekalender.luke17;

import java.util.Arrays;

public class Luke17 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // Takes around 7 milliseconds on my mac book pro
        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
    }


    public static int solve(){
        Brett brett = new Brett();
        Hest hest = new Hest(brett);
        hest.allPositions(Hest.START_POSITION,
                Arrays.asList(brett.numberAt(Hest.START_POSITION)));
        return hest.counter();
    }
}
