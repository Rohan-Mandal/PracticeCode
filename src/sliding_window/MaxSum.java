package sliding_window;

import java.util.Scanner;

public class MaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i]= sc.nextInt();
        }

        System.out.println(findMax(arr,k));
    }

    public static int findMax(int[] arr, int k){
        int i =0, j = 0, sum = 0;
        int max= Integer.MIN_VALUE;

        while (j < arr.length){
            sum = sum + arr[j];

            if(j-i+1 < k){
                j++;
            }
            else if (j-i+1 == k){
                max= Math.max(max,sum);
                sum = sum -arr[i];
                i++;
                j++;
            }
        }
        return max;
    }
}
