package no.knowit.julekalender.luke16;

import java.io.IOException;
import java.math.BigInteger;

public class Luke16 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        // Ta 55ms
        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();

        // Ta 11ms
        System.out.println(solve2() + " Took: " + (System.currentTimeMillis() - start));
    }

    public static int solve() {
        BigInteger number = new BigInteger("2");

        for (int i = 1; i < 10000; i++){
            number = number.multiply(new BigInteger("2"));
            if (number.toString().contains("472047")){
                return i + 1;
            }
        }
        throw new RuntimeException("Not found");
    }

    public static int solve2() {

        char[] nums = new char[1000];
        nums[0] = 1;
        int lastIndex = 1;
        for (int n = 1; n < 10000; n++) {
            char carry = 0;
            for (int i = 0; i < lastIndex; i++) {
                nums[i] = (char) ((nums[i] * 2) + carry);
                if (nums[i] > 9) {
                    carry = 1;
                    nums[i] = (char) (nums[i] - 10);
                } else {
                    carry = 0;
                }
            }

            if (carry == 1){
                nums[lastIndex] = 1;
                lastIndex++;
            }

            if (lastIndex > 6 && contains(nums, new char[]{4,7,2,0,4,7}, lastIndex)){
                return n;
            }
        }
        throw new RuntimeException("Not found");
    }

    private static boolean contains(char[] haystack, char[] needle, int max){
        for (int i = needle.length - 1; i < max; i++){
            boolean found = true;
            for (int j = needle.length - 1; j >= 0; j--){
                if (haystack[i - j] != needle[j]){
                    found = false;
                    break;
                }
            }

            if (found){
                return true;
            }
        }
        return false;
    }
}
