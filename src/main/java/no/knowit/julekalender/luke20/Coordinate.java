package no.knowit.julekalender.luke20;


public class Coordinate {
    public final int x;
    public final int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int toNumber() {

        int xCopy = Math.abs(x);
        int yCopy = Math.abs(y);

        float my_variable = 123.1f;


        int number = 0;

        while (xCopy > 0 || yCopy > 0){
            number += (xCopy % 10) + (yCopy % 10);
            xCopy /= 10;
            yCopy /= 10;

        }
        return number;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Coordinate add (Coordinate coordinate){
        return new Coordinate(x + coordinate.x, y + coordinate.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
