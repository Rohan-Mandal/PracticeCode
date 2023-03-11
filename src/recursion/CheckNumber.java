package recursion;

import java.util.Scanner;

public class CheckNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
       boolean ans = checkNumber(arr,x);
        System.out.println(ans);
    }

    static boolean checkNumber(int[] input, int x){

        if(input.length == 0){
            return false;
        }

        if(input[0] == x){
            return true;
        }
        int [] arr2 = new int[input.length-1];
        for (int i = 1; i < input.length ; i++) {
            arr2[i-1] = input[i];
        }
        return checkNumber(arr2,x);
    }

}
