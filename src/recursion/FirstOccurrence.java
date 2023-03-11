package recursion;

import java.util.Scanner;

public class FirstOccurrence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int ans = firstIndex(arr,x);
        System.out.println(ans);
    }

    static int firstIndex(int[] arr, int x){
        if(arr.length == 0){
            return -1;
        }

        if(arr[0] == x){
            return 0;
        }

        int [] arr2 = new int[arr.length-1];
        for (int i = 1; i < arr.length ; i++) {
            arr2[i-1] = arr[i];
        }

        int result = firstIndex(arr2,x);
        if(result == -1){
            return -1;
        }
        else {
            return result +1;
        }

    }
}
