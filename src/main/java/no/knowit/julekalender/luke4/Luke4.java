package no.knowit.julekalender.luke4;

import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;

public class Luke4 {
    public final static String URL = "https://dl.dropboxusercontent.com/u/45621/kilma_data_blindern.txt";

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Lowest temperatur in December: " +  solve().toString("dd.MM.yyyy"));
    }

    public static DateTime solve() throws IOException, ParseException {
        Data lowest = Data.MAX;
        String currentLine;

        BufferedReader reader = downloadReader();

        while ((currentLine = reader.readLine()) != null) {
            if (Data.isValid(currentLine)) {
                Data data = Data.parse(currentLine);

                if (data.temperatur < lowest.temperatur
                        && data.date.monthOfYear().get() == 12) {
                    lowest = data;
                }
            }
        }
        return lowest.date;
    }

    private static BufferedReader downloadReader() throws IOException {
        URLConnection connection = new URL(URL).openConnection();
        return new BufferedReader(new InputStreamReader(connection.getInputStream()));
    }
}
