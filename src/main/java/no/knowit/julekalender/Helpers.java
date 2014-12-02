package no.knowit.julekalender;
public class Helpers {

    // Explanations:
    // http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
    public static boolean isPrime(int n) {
        for(int i = 2; 2 * i < n; i++) {
            if(n % i== 0)
                return false;
        }
        return true;
    }

    public static boolean isPalindrom(String string){

        if (string.isEmpty()) {
            return true;
        }

        if (string.length() == 1){
            return true;
        }

        if (string.length() == 2 && string.charAt(0) == string.charAt(1)){
            return true;
        }

        if (string.charAt(0) == string.charAt(string.length() - 1)) {
            return isPalindrom(string.substring(1, string.length() - 1));
        } else {
            return false;
        }
    }
}
