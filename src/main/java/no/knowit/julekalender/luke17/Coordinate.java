package no.knowit.julekalender.luke17;

public class Coordinate {
    public final int x;
    public final int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coordinate add (Coordinate coordinate){
        return new Coordinate(x + coordinate.x, y + coordinate.y);
    }
}
