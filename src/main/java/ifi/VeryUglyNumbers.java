package ifi;

public class VeryUglyNumbers {

    private static NoDuplicatesPriorityQueue<Long> heap = new NoDuplicatesPriorityQueue<>(10000);

    public static void main(String []args){
        heap.add(2l);
        heap.add(3l);
        heap.add(5l);

        long start = System.currentTimeMillis();

        // Løsning er
        // 288325195312500000 
        for (int i = 2; i <= 10000; i++){
            System.out.println(i + " " + nextUglyNumber());
        }

        System.out.println("Took: " + (System.currentTimeMillis() - start));
    }

    public static long nextUglyNumber(){
        long value = heap.poll();

        heap.add(value * 2);
        heap.add(value * 3);
        heap.add(value * 5);

        return value;
    }
}
