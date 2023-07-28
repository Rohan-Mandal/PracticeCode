package arrayandarraylist;

import java.util.Scanner;

public class PhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the phone number");
        long phoneNumber = sc.nextLong();
        int evenSum = 0;
        int oddSum = 0;

        while(phoneNumber != 0){
            long remainder = phoneNumber % 10;
            if(remainder % 2 == 0){
                evenSum += remainder;
            }
            else{
                oddSum += remainder;
            }
            phoneNumber = phoneNumber / 10;
        }
        if(oddSum > evenSum){
            System.out.println("sum of odd is greater than sum of even");
        } else if (evenSum > oddSum) {
            System.out.println("Sum of even is greater than sum of odd");
        }
        else{
            System.out.println("Sum of odd and even are equal");
        }
    }
}
