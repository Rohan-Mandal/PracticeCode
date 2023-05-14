package Recursion;

import java.util.Scanner;

public class PrintPermutationString {

    public static void printPermutationsHelper(String input, String outputSoFar){
        if(input.length() == 0){
            System.out.println(outputSoFar);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String leftPart = input.substring(0, i);
            String rightPart = input.substring(i + 1);
            String restString = leftPart + rightPart;
            printPermutationsHelper(restString, outputSoFar + ch);
        }
    }
    public static void printPermutations(String input){
        printPermutationsHelper(input,"");
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input = sc.nextLine();
        printPermutations(input);
        sc.close();
    }
    
}
