package random;

import java.util.Scanner;

public class SumDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int result = sumOfDigits(m);
        System.out.println(result);

    }

    static int sumOfDigits(int n){
        int sum;
        if(n < 10){
            return n;
        }
        sum = (n % 10) + sumOfDigits(n / 10);
        return sum;
    }
}
