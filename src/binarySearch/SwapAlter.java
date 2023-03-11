package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class SwapAlter {

    public static void swap(int[] arr, int size) {
        for (int i = 0; i < size; i += 2) {
            if (i + 1 < size) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrSize = in.nextInt();
        int[] arr = new int[arrSize];
        for (int index = 0; index < arr.length; index++) {
            arr[index] = in.nextInt();
        }
        swap(arr, arrSize);

        System.out.println(Arrays.toString(arr));


    }
}
