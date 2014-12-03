package no.knowit.julekalender.luke3;

import java.util.Comparator;

public class CoordinateMinComparator implements Comparator<Coordinate> {

    @Override
    public int compare(Coordinate o1, Coordinate o2) {
        if (o1.toNummer() < o2.toNummer()) {
            return -1;
        }

        if (o1.toNummer() > o2.toNummer()) {
            return 1;
        }
        return 0;
    }
}
