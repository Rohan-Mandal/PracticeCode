package random;

import java.util.Scanner;

public class LCMandLargestOfSet {
    public static int largestAdjacentLCM(int[] arr) {
        int max_lcm = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int lcm = calculateLCM(arr[i], arr[i + 1]);
            max_lcm = Math.max(max_lcm, lcm);
        }
        return max_lcm;
    }

    public static int calculateLCM(int a, int b) {
        return (a * b) / calculateGCD(a, b);
    }

    public static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int array_length = scan.nextInt();
        int[] arr = new int[array_length];
        for (int j = 0; j < array_length; j++) {
            arr[j] = scan.nextInt();
        }
        int result = largestAdjacentLCM(arr);
        System.out.println(result);
        scan.close();
    }
}
