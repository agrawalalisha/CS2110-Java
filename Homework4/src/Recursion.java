/**
 * Homework 4 
 * Implement the following methods on recursion as defined in the homework 4 document.
 * 
 * @author Alisha Agrawal ( aa3se )
 */

public class Recursion {
    
    /**
     * Checks if a String is a palindrome. Returns true if the String is a palindrome
     * 
     * @param s The String to be checked
     * @return Whether or not the String is a palindrome
     */
    public static boolean palindrome(String s) {

        int length = s.length();
        if (length <= 1) {
            return true;
        }
        char first = Character.toLowerCase(s.charAt(0));
        char last = Character.toLowerCase(s.charAt(length - 1));
        if (first == last) {
            String shortS = s.substring(1, length - 1);
            return palindrome(shortS);
        } else {
            return false;
        }
    }

    /**
     * Reverses a String. Returns a String.
     * 
     * @param s The String to be reversed
     * @return The reversed String
     */
    public static String reverseString(String s) {

        if (s.isEmpty()) { // check if the String is empty
            return s;
        }
        // keep putting the first letter (index 0) of the manipulated string at the end
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    /**
     * Calculates the total number of handshakes n people in the room can shake. Returns an int.
     * 
     * @param n The number of people in a room
     * @return The total number of handshakes n people in the room can shake
     */
    public static int handshakes(int n) {

        if (n <= 1) {
            return 0;
        }
        // number of handshakes is equal to 0 + 1 + ... n - 1;
        return handshakes(n - 1) + (n - 1);
    }
    
    /**
     * Tests how well a computer performs recursion using Ackermann's function. Returns a long.
     * 
     * @param m A long
     * @param n A long
     * @return The solution to the Ackermann's function.
     */
    public static long ackermann(long m, long n) {

        if (m == 0) {
            return n + 1;
        } else if (m > 0 && n == 0) {
            return ackermann(m - 1, 1);
        } else if (m > 0 && n > 0) {
            return ackermann(m - 1, ackermann(m, n - 1));
        }
        return 0;
    }

    public static void main(String[] args) {
        String word1 = "racecar";       
        String word2 = "abba";         
        String word3 = "smith";         
        String word4 = "aysdfdjkya";      
        String word5 = "xrtiitrx";      
        
        // PALINDROME() METHOD TESTING
        System.out.println("PALINDROME() METHOD TESTING");
        System.out.println("Is " + word1 + " a palindrome? " + palindrome(word1)); // true
        System.out.println("Is " + word2 + " a palindrome? " + palindrome(word2)); // true
        System.out.println("Is " + word3 + " a palindrome? " + palindrome(word3)); // false
        System.out.println("Is " + word4 + " a palindrome? " + palindrome(word4)); // false
        System.out.println("Is " + word5 + " a palindrome? " + palindrome(word5)); // true
        
        // REVERSESTRING() METHOD TESTING
        System.out.println("");
        System.out.println("REVERSESTRING() METHOD TESTING");
        System.out.println("Is " + word1 + " reversed? " + reverseString(word1)); // racecar
        System.out.println("Is " + "CS2110" + " reversed? " + reverseString("CS2110")); // 0112SC
        System.out.println("Is " + "I love CS" + " reversed? " + reverseString("I love CS")); // !SC evol I
        System.out.println("Is " + word2 + " reversed? " + reverseString(word2)); // abba
        System.out.println("Is " + word3 + " reversed? " + reverseString(word3)); // htims
        
        // HANDSHAKE() METHOD TESTING
        System.out.println("");
        System.out.println("HANDSHAKE() METHOD TESTING");
        System.out.println("How many handshakes possible with 1 person in the room? " + handshakes(1)); // 0
        System.out.println("How many handshakes possible with 3 person in the room? " + handshakes(3)); // 3
        System.out.println("How many handshakes possible with 6 person in the room? " + handshakes(6)); // 15
        System.out.println("How many handshakes possible with 13 person in the room? " + handshakes(13)); // 78
        System.out.println("How many handshakes possible with 0 person in the room? " + handshakes(0)); // 0
        
        // ACKERMANN() METHOD TESTING
        System.out.println("");
        System.out.println("HANDSHAKE() METHOD TESTING");
        System.out.println("The result from the Ackermann's function: " + ackermann(0, 0)); // 1
        System.out.println("The result from the Ackermann's function: " + ackermann(2, 0)); // 3
        System.out.println("The result from the Ackermann's function: " + ackermann(3, 4)); // 125
        System.out.println("The result from the Ackermann's function: " + ackermann(1, 1)); // 3
        System.out.println("The result from the Ackermann's function: " + ackermann(2, 1)); // 5

    }
}
