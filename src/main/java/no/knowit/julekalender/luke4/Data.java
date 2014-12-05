package no.knowit.julekalender.luke4;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;

public class Data {

    public final DateTime date;
    public final double temperatur;

    public static final Data MAX = new Data(new DateTime(), Double.MAX_VALUE);

    private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("dd.MM.yyyy");

    private Data(DateTime date, double temperatur){
        this.date = date;
        this.temperatur = temperatur;
    }

    public static Data parse(String rawLine) throws ParseException {

        String[] fields = rawLine.trim().split(" +");

        DateTime date = new DateTime(FORMATTER.parseDateTime(fields[1]));
        double temperatur = Double.parseDouble(fields[3].replace(",", "."));

        return new Data(date, temperatur);
    }

    public static boolean isValid(String raw) {
        if (raw.trim().startsWith("18700") && !raw.contains("OSLO")){
            return true;
        } else {
            return false;
        }
    }
}
