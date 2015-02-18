package no.knowit.julekalender.luke20;


public class Luke20 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // Takes around 7 milliseconds on my mac book pro
        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
    }



    public static int solve(){

        start = 15;

        Rudolf rudolf = new Rudolf();
        rudolf.allPositions(new Coordinate(0,0));

        return rudolf.answer();
    }
}
