package no.knowit.julekalender.luke3;

public class Luke3 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // Takes around 3 milliseconds on my mac book pro
        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
    }


    public static int solve(){
        Brett brett = new Brett();
        Hest hest = new Hest(brett);
        for (int i = 0; i < 200; i ++) {
            Coordinate current = hest.current();
            Coordinate newPosition = hest.nextPosition();
            hest.moveHest(newPosition);
            brett.toogleFarge(current);
        }
        return brett.svarteRuter();
    }
}
