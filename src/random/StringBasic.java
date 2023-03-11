package random;

import java.util.Scanner;

public class StringBasic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String originalWord = sc.nextLine();

      /*  String result = reverseWord(originalWord);
        System.out.println(result);*/

        /*String result1 = reversePosition(originalWord);
        System.out.println(result1);*/

       /* String result3 = palindrome(originalWord);
        System.out.println(result3);*/

        String result4 = reverseWithoutChanging(originalWord);
        System.out.println(result4);

    }

    public static String reverseWord(String word) {
        String[] words = word.split("\\s");
        StringBuilder reverseString = new StringBuilder();
        for (String splitWord : words) {
            StringBuilder reverseWord = new StringBuilder();
            for (int j = splitWord.length() - 1; j >= 0; j--) {
                reverseWord.append(splitWord.charAt(j));
            }
            reverseString.append(reverseWord).append(" ");
        }
        return reverseString.toString();
    }

    public static String reversePosition(String word) {
        String[] words = word.split("\\s");
        StringBuilder reverseString = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                reverseString.insert(0, words[i]);
            } else {
                reverseString.insert(0, " " + words[i]);
            }
        }
        return reverseString.toString();
    }

    public static String palindrome(String word) {
        String reverseString = new StringBuilder(word).reverse().toString();

        if (word.equals(reverseString)) {
            return "Palindrome";
        } else {
            return "Not Palindrome";
        }
    }

    public static String reverseWithoutChanging(String input) {
        String[] words = input.split("\\s");
        String reverse = "";
        for (int i = 0; i < words.length; i++) {
            for (int j = words[i].length() - 1; j >= 0; j--) {
                reverse += words[i].charAt(j);
            }
            reverse = reverse +" ";
        }
        return reverse;
    }
}

