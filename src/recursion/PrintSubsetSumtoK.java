package Recursion;

import java.util.Scanner;

public class PrintSubsetSumtoK {
    static Scanner s = new Scanner(System.in);

    public static void printSubsetsSumTokHelper(int[] input, int k, int startIndex, int[] outputSoFar){
		if(startIndex == input.length){
			if(k == 0)
            {
                for(int i = 0; i < outputSoFar.length; i++){
                    System.out.print(outputSoFar[i] + " ");
                }
                System.out.println();
                return;
            }
            else
                return;
		}

        printSubsetsSumTokHelper(input, k, startIndex + 1, outputSoFar);

        int[] newOutput = new int[outputSoFar.length + 1];
        int i = 0;
        for (; i < outputSoFar.length; i++) {
            newOutput[i] = outputSoFar[i];
        }
        newOutput[i] = input[startIndex];
        printSubsetsSumTokHelper(input, k - input[startIndex], startIndex + 1, newOutput);
	}
	
	public static void printSubsetsSumTok(int input[], int k) {
		int[] output = new int[0];
		printSubsetsSumTokHelper(input, k, 0, output);
	}

    public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int k = s.nextInt();
		printSubsetsSumTok(input, k);
	}
    
}
