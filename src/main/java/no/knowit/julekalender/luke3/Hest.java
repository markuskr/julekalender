package no.knowit.julekalender.luke3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hest {

    private final Brett brett;

    private Coordinate current = new Coordinate(0, 0);

    private List<Coordinate> movingPattern = Arrays.asList(
            new Coordinate(2,1), new Coordinate(-2,1), new Coordinate(2,-1), new Coordinate(-2,-1),
            new Coordinate(1,2), new Coordinate(-1,2), new Coordinate(1,-2), new Coordinate(-1,-2));

    public Hest(Brett brett){
        this.brett = brett;
    }

    public Coordinate current() {
        return current;
    }

    public void moveHest(Coordinate newPosition){
        this.current = newPosition;
    }

    public Coordinate nextPosition() {
        List<Coordinate> newPositions = new ArrayList<>();

        int minRouteId = Integer.MAX_VALUE;
        int maxRouteId = Integer.MIN_VALUE;
        int minIndex = -1;
        int maxIndex = -1;

        for (int i = 0; i < movingPattern.size(); i++){
            Coordinate newPosition = current.add(movingPattern.get(i));

            newPositions.add(newPosition);

            if (newPosition.isValid()
                    && newPosition.toNummer() < minRouteId
                    && brett.fargeAt(current) == brett.fargeAt(newPosition)){
                minIndex = i;
                minRouteId = newPosition.toNummer();
            }

            if (newPosition.isValid() && newPosition.toNummer() > maxRouteId){
                maxIndex = i;
                maxRouteId = newPosition.toNummer();

            }
        }

        if (minIndex > -1) {
            return newPositions.get(minIndex);
        } else {
            return newPositions.get(maxIndex);
        }
    }
}
