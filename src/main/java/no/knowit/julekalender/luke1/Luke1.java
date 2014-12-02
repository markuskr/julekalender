package no.knowit.julekalender.luke1;

import no.knowit.julekalender.Helpers;

public class Luke1 {

    public static void main(String[] args) {
        System.out.println(solve(1000000));
    }

    public static int solve(int max){
        int count = 0;

        for (int i = 1; i <= max; i++){
            if (Helpers.isPalindrom(Integer.toString(i)) && Helpers.isPalindrom(Integer.toOctalString(i))){
                count ++;
                System.out.println(Integer.toString(i) + "/" + Integer.toOctalString(i));
            }
        }
        return count;
    }
}
