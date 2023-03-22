package Recursion;
import java.util.*;
public class PrintSubsequences {

    public static void printSubsequences(String input, String SequenceSoFar){
        if(input.length() == 0){
            System.out.println(SequenceSoFar);
            return;
        }
        String smallInput = input.substring(1);
        printSubsequences(smallInput, SequenceSoFar);
        printSubsequences(smallInput, SequenceSoFar + input.charAt(0));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        printSubsequences(str, "");
        sc.close();
    }
}
