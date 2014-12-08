package no.knowit.julekalender.luke7;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Luke7 {

    //public final static String URL = "http://upload.wikimedia.org/wikipedia/en/archive/f/f4/20100830193250!The_Scream.jpg";
    public final static String URL = "https://dl.dropboxusercontent.com/u/42659711/Santa.png";

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
    }

    public static int solve() throws IOException {
        BufferedImage image = downloadImage();

        Map<Integer, Integer> counters = new HashMap<>();

        for (int x = 0; x < image.getWidth(); x++){
            for (int y = 0; y < image.getHeight(); y++){
                int rgb = image.getRGB(x,y);

                if (counters.containsKey(rgb)) {
                    counters.put(rgb, counters.get(rgb) + 1);
                } else {
                    counters.put(rgb, 1);
                }
            }
        }

        List<Integer> amounts = new ArrayList<>(counters.values());
        Collections.sort(amounts, Collections.reverseOrder());

        return amounts.get(9);

    }

    private static BufferedImage downloadImage() throws IOException {
        URL url = new URL(URL);
        return ImageIO.read(url);
    }
}
