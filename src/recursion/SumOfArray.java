package recursion;

import java.util.Scanner;

public class SumOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = sum(arr);
        System.out.println(ans);
    }

    public static int sum(int input[]) {
        if(input.length == 1){
          //  int value = input[0];
            return input[0];
        }

        int [] arr2 = new int[input.length-1];
        for (int i = 1; i < input.length ; i++) {
            arr2[i-1] = input[i];
        }
        int ans = input[0] + sum(arr2);
        return ans;

    }
}
