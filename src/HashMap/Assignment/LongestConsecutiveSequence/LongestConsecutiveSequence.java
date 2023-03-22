package Assignment.LongestConsecutiveSequence;

import java.io.*;
import java.util.*;

public class LongestConsecutiveSequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }

        String[] strNums;
        strNums = br.readLine().split("\\s");

        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void printArray(ArrayList<Integer> arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        int[] arr = takeInput();
        ArrayList<Integer> ans = Solution1.longestConsecutiveIncreasingSequence(arr); //13  2 12 9 16 10 5 3 20 25 11 1 8 6
        printArray(ans);

    }
}
