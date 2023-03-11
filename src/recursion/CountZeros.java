package recursion;

import java.util.Scanner;

public class CountZeros {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int result = countZeroesRecursively(n);
        System.out.println(result);

    }

    public static int countZeroesRecursively(int input){
        if(input == 0){
            return 1;
        }
        if(input == 1){
            return 0;
        }
        int lastDigit = input % 10;
        if(lastDigit == 0){
            return 1 + countZeroesRecursively(input / 10);
        }
        else {
            return countZeroesRecursively(input / 10);
        }
    }
}
