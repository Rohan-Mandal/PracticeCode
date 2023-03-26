package DP;

import java.util.Scanner;

public class Fibonacci {

    public static int fibonacci(int n, int[] fibArray){
        if(n == 0 || n == 1){
            return n;
        }
        int ans1, ans2;
        if(fibArray[n - 1] == -1) {
            ans1 = fibonacci(n - 1, fibArray);
            fibArray[n - 1] = ans1;
        }
        else{
            ans1 = fibArray[n - 1];
        }

        if(fibArray[n - 2] == -1) {
            ans2 = fibonacci(n - 2, fibArray);
            fibArray[n - 2] = ans2;
        }
        else{
            ans2 = fibArray[n - 2];
        }
        int myAns = ans1 + ans2;
        return myAns;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fibArray = new int[n + 1];
        for (int i = 0; i < fibArray.length; i++) {
            fibArray[i] = -1;
        }
        int ans = fibonacci(n, fibArray);
        System.out.println(ans);
    }
}
