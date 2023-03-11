package recursion;

import java.util.Scanner;

public class SortedArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }
        int startIndex = sc.nextInt();
        boolean ans = isSortedBetter(arr, startIndex);
        System.out.println(ans);
       // System.out.println(isSorted(arr));
    }

    /*static boolean isSorted(int[] arr){
        if(arr.length == 1){
            return true;
        }
        if(arr[0] > arr[1]){
            return false;
        }

        int [] arr2 = new int[arr.length-1];
        for (int i = 1; i < arr.length ; i++) {
            arr2[i-1] = arr[i];
        }
        return isSorted(arr2);
    }*/

    static boolean isSortedBetter(int[] arr, int startIndex){

        if (startIndex == arr.length - 1){
            return true;
        }
        if(arr[startIndex] > arr[startIndex + 1]){
            return false;
        }

        return isSortedBetter(arr, startIndex + 1);

    }
}
