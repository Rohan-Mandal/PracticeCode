package Recursion;

import java.util.Scanner;

public class KeypadSolution {

	public static String getOption(int digit) {
		if (digit == 2) {
			return "abc";
		}
		if (digit == 3) {
			return "def";
		}
		if (digit == 4) {
			return "ghi";
		}
		if (digit == 5) {
			return "jkl";
		}
		if (digit == 6) {
			return "mno";
		}
		if (digit == 7) {
			return "pqrs";
		}
		if (digit == 8) {
			return "tuv";
		}
		if (digit == 9) {
			return "wxyz";
		}
		return "";
	}

	public static String[] keypadCombination(int n) {
		// base case
		if (n == 0) {
			String[] output = { "" };
			return output;
		}
		// recursive case
		String[] smallOutput = keypadCombination(n / 10);
		int lastDigit = n % 10;
		String lastDigitOption = getOption(lastDigit);
		String[] output = new String[smallOutput.length * lastDigitOption.length()];
		int k = 0;
		for (int i = 0; i < smallOutput.length; i++) {
			for (int j = 0; j < lastDigitOption.length(); j++) {
				output[k/* i * lastDigitOption.length() + j */] = smallOutput[i] + lastDigitOption.charAt(j);
			}
		}
		return output;

	}

	public static void printKeypadCombinations(int input, String stringSoFar){
		if(input == 0){
			System.out.println(stringSoFar);
			return;
		}
		int smallInput = input / 10;
		int lastDigit  = input % 10;
		String lastDigitOption = getOption(lastDigit);
		for(int i = 0; i < lastDigitOption.length(); i++){
			printKeypadCombinations(smallInput, lastDigitOption.charAt(i) + stringSoFar);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number:");
		int input = s.nextInt();
		printKeypadCombinations(input, "");
		// String output[] = keypadCombination(input);
		// for (String outputString : output) {
		// 	System.out.println(outputString);
		// }
		s.close();
	}
}
