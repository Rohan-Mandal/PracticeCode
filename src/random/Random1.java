package random;

import java.util.Scanner;

public class Random1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int result = multiplyRec(m, n);
        System.out.println(result);
    }

    static int multiplyRec(int m, int n){
        if(n == 1)
            return m;
        int mul = multiplyRec(m,  n - 1);
        return m + mul;
    }
}
