package no.knowit.julekalender.Luke15;


import no.knowit.julekalender.Helpers;

import java.io.IOException;
import java.util.List;

public class Luke15 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
    }

    public static int solve() {
        int counter = 0;

        for (int i = 9; i < 100; i++){
            for (int j = i; j < 100; j++){
                int produkt = i * j;
                List<Integer> produktList = Helpers.toList(produkt);
                List<Integer> faktorList = Helpers.toList(i * 100 + j);

                if (Helpers.intLength(produkt) == 4
                 && containsElementwise(produktList, faktorList)){
                    counter ++;
                }
            }
        }
        return counter;
    }

    private static boolean containsElementwise(List<Integer> list1, List<Integer> list2){
        while (!list1.isEmpty()){
            if (!list2.contains(list1.get(0))){
                return false;
            } else {
                list2.remove(list1.get(0));
            }
            list1.remove(0);
        }
        return true;
    }
}
