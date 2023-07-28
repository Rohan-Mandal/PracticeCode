package random;

import java.util.Scanner;

public class TenNumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = sc.nextInt();
        int sum = 0;

        for(int i = num; i < (num + 10); i++){
            sum += i;
        }
        System.out.println("The sum of then numbers is "+sum);
    }
}
