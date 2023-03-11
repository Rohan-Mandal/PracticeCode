package recursion;

import java.util.Scanner;

public class CountTheDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(count(num));

    }

    static int count(int num){
        if( num == 0){
            return 0;
        }
        return count(num/10) + 1;

    }
}
