package recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 5, 4, 9, 6, 12};
        sort(arr,0, arr.length -1);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] input, int startIndex, int endInedx){
        if(startIndex >= endInedx){
            return;
        }

        int start = startIndex;
        int end = endInedx;
        int mid = start + (end - start) / 2;
        int pivot = input[mid];

        while (start <= end){
            while(input[start] < pivot){
                start++;
            }
            while(input[end] > pivot){
                end--;
            }

            if(start <= end){
                int temp = input[start];
                input[start] = input[end];
                input[end] = temp;
                start++;
                end--;
            }
        }
        sort(input, startIndex, end);
        sort(input, start, endInedx);
    }
}
