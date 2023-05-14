package Recursion;

import java.util.*;

public class SubsequenceString{


    public static String[] Subsequences(String input){
        //base case
        if(input.length() == 0){
            String[] output = new String[1];
            output[0] = "";
            return output;
        }
        //recursive case
        String[] smallOutput = Subsequences(input.substring(1));
        String [] output = new String[smallOutput.length * 2];
        for(int i = 0; i < smallOutput.length; i++){
            output[i] = smallOutput[i];
        }
        for(int i = 0; i < smallOutput.length; i++){
            output[smallOutput.length + i] = input.charAt(0) + smallOutput[i];
        }
        return output;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        String [] outpStrings = Subsequences(str);
        for (String string : outpStrings) {
            System.out.println(string);
        }
        sc.close();
    }
}