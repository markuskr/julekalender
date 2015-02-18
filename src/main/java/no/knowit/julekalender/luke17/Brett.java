package no.knowit.julekalender.luke17;


public class Brett {

    private int[][] brett = new int[][] {
            new int[]{1,2,3},
            new int[]{4,5,6},
            new int[]{7,8,9},
            new int[]{-1,0,-1},
    };

    public Brett() {
    }

    public int numberAt(Coordinate coordinate){
        return brett[coordinate.y][coordinate.x];
    }

    public boolean isValid(Coordinate coordinate){
        return coordinate.x >= 0 && coordinate.y >= 0
            && coordinate.x < 3 && coordinate.y < 4
            && brett[coordinate.y][coordinate.x] != -1;
    }
}
