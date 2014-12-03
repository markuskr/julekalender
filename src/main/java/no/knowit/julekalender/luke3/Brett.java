package no.knowit.julekalender.luke3;

public class Brett {

    private static int X = 10;
    private static int Y = 10;

    private enum Farge {

        SVART ("S"), HVIT("H");

        private final String representasjon;

        private Farge(String representasjon){
            this.representasjon = representasjon;
        }

        public String representasjon(){
            return representasjon;
        }

    }

    public Brett() {
        for (int x = 0; x < X; x++){
            for (int y = 0; y < Y; y++){
                brett[x][y] = Farge.HVIT;
            }
        }
    }

    public int svarteRuter() {

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


    private Farge[][] brett = new Farge[X][Y];

    public void print() {

        for (int x = 0; x < X; x++){
            System.out.print("----");
        }
        System.out.println("-");
        for (int x = 0; x < X; x++){
            System.out.print("| ");
            for (int y = 0; y < Y; y++) {
                System.out.print(brett[x][y].representasjon() + " | ");
            }
            System.out.println("");

            for (int l = 0; l < X; l++){
                System.out.print("----");
            }
            System.out.println("-");
        }
    }
}
