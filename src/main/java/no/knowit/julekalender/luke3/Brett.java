package no.knowit.julekalender.luke3;

public class Brett {

    private enum Farge {
        SVART , HVIT;
    }

    private static int X = 10;
    private static int Y = 10;

    private Farge[][] brett = new Farge[X][Y];

    public Brett() {
        for (int x = 0; x < X; x++){
            for (int y = 0; y < Y; y++){
                brett[x][y] = Farge.HVIT;
            }
        }
    }

    public int antallSvarteRuter() {
        int counter = 0;

        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {

                if (brett[x][y] == Farge.SVART) {
                    counter ++;
                }
            }
        }

        return counter;
    }

    public void toogleFarge (Coordinate coordinate){
        if (fargeAt(coordinate) == Farge.HVIT){
            brett[coordinate.x][coordinate.y] = Farge.SVART;
        } else {
            brett[coordinate.x][coordinate.y] = Farge.HVIT;
        }
    }

    public Farge fargeAt(Coordinate coordinate){
        return brett[coordinate.x][coordinate.y];
    }

    public boolean isValid(Coordinate coordinate){
        return coordinate.x >= 0 && coordinate.y >= 0 && coordinate.x < 10 && coordinate.y < 10;
    }
}
