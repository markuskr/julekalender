package no.knowit.julekalender.luke20;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rudolf {

    private final List<Coordinate> movingPattern = Arrays.asList(
            new Coordinate(1, 0), new Coordinate(-1, 0), new Coordinate(0, 1), new Coordinate(0, -1));

    private Set<Coordinate> coordinates = new HashSet<>();

    public Rudolf(){
        coordinates.add(new Coordinate(0,0));
    }

    public void allPositions(Coordinate current) {
        for (Coordinate move : movingPattern){
            Coordinate newPosition = current.add(move);

            if (newPosition.toNumber() <= 19 && !coordinates.contains(newPosition)){
                coordinates.add(newPosition);
                allPositions(newPosition);
            }
        }
    }

    public int answer(){
        return coordinates.size();
    }
}

