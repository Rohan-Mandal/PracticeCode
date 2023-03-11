package recursion;

import java.util.Scanner;

public class LastOccurrence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int ans = lastIndex(arr,x);
        System.out.println(ans);
    }

    static int lastIndex(int[] input, int x){
        if(input.length == 0){
            return -1;
        }

        if(input[input.length-1] == x){
            return input.length - 1;
        }

        int [] arr2 = new int[input.length-1];
        for (int i = 1; i < input.length - 2 ; i++) {
            arr2[i-1] = input[i];
        }
        int result = lastIndex(arr2,x);
        if(result != -1){
            return result + 1;
        }
        else{
            if(input[0] == x){
                return 0;
            }
            else {
                return -1;
            }
        }

    }
}
