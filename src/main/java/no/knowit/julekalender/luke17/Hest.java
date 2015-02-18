package no.knowit.julekalender.luke17;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hest {
    public static final Coordinate START_POSITION = new Coordinate(0, 0);

    private final List<Coordinate> movingPattern = Arrays.asList(
            new Coordinate(2,1), new Coordinate(-2,1), new Coordinate(2,-1), new Coordinate(-2,-1),
            new Coordinate(1,2), new Coordinate(-1,2), new Coordinate(1,-2), new Coordinate(-1,-2));

    private final Brett brett;

    public Hest(Brett brett){
        this.brett = brett;
    }

    private int counter = 0;

    public int counter(){
        return counter;
    }

    public void allPositions(Coordinate current, List<Integer> visitedNumbers) {
        if (visitedNumbers.size() == 10){
            counter ++;
            return;
        }

        for (Coordinate move : movingPattern){
            Coordinate newPosition = current.add(move);

            if (brett.isValid(newPosition)){
                List<Integer> copy = new ArrayList<>(visitedNumbers);
                copy.add(brett.numberAt(newPosition));
                allPositions(newPosition, copy);
            }
        }
    }
}
