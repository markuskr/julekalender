package no.knowit.julekalender.luke18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mkr on 18/12/14.
 */
public class Luke18 {

    public final static String URL = "https://dl.dropboxusercontent.com/u/42659711/words.txt";

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(solve());
    }



    public static String solve() throws IOException, ParseException {

        Map <String, Integer> mapping = new HashMap<>();

        String currentLine;

        BufferedReader reader = downloadReader();

        while ((currentLine = reader.readLine()) != null) {
            List<Character> chars = new ArrayList<>();

            for (int i = 0; i < currentLine.length(); i++) {
                chars.add(new Character(currentLine.toLowerCase().charAt(i)));
            }

            Collections.sort(chars);

            String annagramm = "";

            for (Character c : chars){
                annagramm += c;
            }

            if (mapping.containsKey(annagramm)){
                mapping.put(annagramm, mapping.get(annagramm) + 1);
            } else {
                mapping.put(annagramm, 1);
            }
        }
        String word = "";
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> value : mapping.entrySet()){
            if (value.getValue() > max ){
                max = value.getValue();
                word = value.getKey();
            }
        }

        return word;
    }


    private static BufferedReader downloadReader() throws IOException {
        URLConnection connection = new URL(URL).openConnection();
        return new BufferedReader(new InputStreamReader(connection.getInputStream()));
    }
}
