package Recursion;

import java.util.Scanner;

public class PrintSubsetsArray {
    static Scanner s = new Scanner(System.in);



    public static void printSubsetsHelper(int[] input, int startIndex, int[] outputSoFar){
		//base case
		if(startIndex == input.length){
			for (int i = 0; i < outputSoFar.length; i++) {
				System.out.print(outputSoFar[i] + " ");
			}
			System.out.println();
			return;
		}

		printSubsetsHelper(input, startIndex + 1, outputSoFar);
		int[] newOutput = new int[outputSoFar.length + 1];
		int i = 0;
		for (; i < outputSoFar.length; i++) {
			newOutput[i] = outputSoFar[i];
		}
		newOutput[i] = input[startIndex];
		printSubsetsHelper(input, startIndex + 1, newOutput);
	}

	public static void printSubsets(int input[]) {
		// Write your code here
		int[] output = new int[0];
		printSubsetsHelper(input, 0, output);
	}

    public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
        s.close();
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		printSubsets(input);
    }
}
