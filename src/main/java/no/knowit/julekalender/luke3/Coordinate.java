package no.knowit.julekalender.luke3;


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

    public int toNummer(){
        return x * 10 + y;
    }

    public boolean isValid(){
        return x >= 0 && y >= 0 && x < 10 && y < 10;
    }
}
