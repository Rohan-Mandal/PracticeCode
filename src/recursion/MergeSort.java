package recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] arr = {8, 5, 4, 9, 6, 12};
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public  static int[] sort(int[] input){
        if(input.length == 1){
            return input;
        }
        int middle = input.length / 2;
        int[] left = sort(Arrays.copyOfRange(input,0, middle));
        int[] right = sort(Arrays.copyOfRange(input, middle, input.length));

        return merge(left, right);
    }

    public static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < first.length && j < second.length) {
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while(i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;

    }
}
