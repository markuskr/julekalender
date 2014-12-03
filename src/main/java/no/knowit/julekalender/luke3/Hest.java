package no.knowit.julekalender.luke3;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Hest {

    private static final Coordinate START_POSITION = new Coordinate(0, 0);

    private final CoordinateMinComparator minComparator = new CoordinateMinComparator();
    private final CoordinateMaxComparator maxComparator = new CoordinateMaxComparator();

    private Coordinate current = START_POSITION;

    private final List<Coordinate> movingPattern = Arrays.asList(
            new Coordinate(2,1), new Coordinate(-2,1), new Coordinate(2,-1), new Coordinate(-2,-1),
            new Coordinate(1,2), new Coordinate(-1,2), new Coordinate(1,-2), new Coordinate(-1,-2));


    private final Brett brett;

    public Hest(Brett brett){
        this.brett = brett;
    }

    public Coordinate current() {
        return current;
    }

    public void moveTo(Coordinate newPosition){
        this.current = newPosition;
    }

    public Coordinate nextPosition() {
        PriorityQueue<Coordinate> sameRute = new PriorityQueue<>(8, minComparator);
        PriorityQueue<Coordinate> otherRute = new PriorityQueue<>(8, maxComparator);

        for (Coordinate move : movingPattern){
            Coordinate newPosition = current.add(move);

            if (brett.isValid(newPosition)
                    && brett.fargeAt(current) == brett.fargeAt(newPosition)){
                sameRute.add(newPosition);
            }

            if (brett.isValid(newPosition)){
                otherRute.add(newPosition);
            }
        }

        if (!sameRute.isEmpty()) {
            return sameRute.peek();
        } else if (!otherRute.isEmpty()) {
            return otherRute.peek();
        } else {
            throw new RuntimeException("No move possible");
        }
    }
}
