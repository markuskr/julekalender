package no.knowit.julekalender.luke10;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Luke10 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
    }

    private static List<Integer> bord = new ArrayList<>(1500);
    private final static Iterator<Integer> removeNext(Iterator<Integer> person) {
        for (int i = 0; i < 2; i++){
            if (!person.hasNext()){
                person = bord.iterator();
            }
            person.next();
        }
        person.remove();
        return person;
    }

    public static int solve() {
        for (int i = 1; i <= 1500; i++){
            bord.add(i);
        }

        Iterator<Integer> person = bord.iterator();

        while (bord.size() > 1){
            person = removeNext(person);
        }

        return bord.get(0);
    }
}
