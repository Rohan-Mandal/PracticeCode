package recursion;

import java.util.Scanner;

public class Staircase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = staircaseCount(n);
        System.out.println(result);
    }

    public static int staircaseCount(int n){
        if(n == 0){
            return 1;
        }
        else if(n < 0){
            return 0;
        }
        return staircaseCount(n - 1) + staircaseCount(n - 2) + staircaseCount(n - 3);
    }

   /* public static int staircaseCount(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++)
            res[i] = res[i - 1] + res[i - 2] + res[i - 3];

        return res[n];
    }*/
}

