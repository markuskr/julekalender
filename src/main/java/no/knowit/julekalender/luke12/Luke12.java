package no.knowit.julekalender.luke12;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by mkr on 12/12/14.
 */
public class Luke12 {

    private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("dd.MM.yyyy");

    public static void main(String[] args) throws IOException, ParseException {
        long start = System.currentTimeMillis();
        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
    }

    public static int solve() throws IOException, ParseException {
        int count = 0;
        DateTime current = new DateTime(FORMATTER.parseDateTime("01.01.1337"));
        DateTime end = new DateTime(FORMATTER.parseDateTime("12.12.2014"));

        while (current.isBefore(end)){

            if (current.getDayOfWeek() == 5 && current.getDayOfMonth() == 13){
                count ++;
            }

            if (current.getDayOfWeek() == 5) {
                current = current.plusDays(7);
            } else {
                current = current.plusDays(1);
            }
        }

        return count;

    }
}
