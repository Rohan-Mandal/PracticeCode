package Recursion;

import java.util.*;


public class ReturnPermutationsString {


    public static String[] permutationOfString(String input){
        // Write your code here
        if(input.length() == 0){
            String[] ans = {""};
            return ans;
        }
    
        String[] permutations = permutationOfString(input.substring(1));
        String output[] = new String[permutations.length * input.length()];
        int k = 0;
        for (int i = 0; i < permutations.length; i++) {
            for (int j = 0; j <= permutations[i].length(); j++) {
                output[k++] = permutations[i].substring(0,j) + input.charAt(0) + permutations[i].substring(j);
            }
        }
        return output;
    }
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String output[] = permutationOfString(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
        s.close();
	}
}
