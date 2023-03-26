package random;


import java.util.*;

public class LCMOfAdjacentElements {

        public static int largestAdjacentLCM(int array_length, List<Integer> arr) {
            int largestLCM = 0;
            for (int i = 1; i < array_length; i++) {
                int lcm = calculateLCM(arr.get(i - 1), arr.get(i));
                largestLCM = Math.max(largestLCM, lcm);
            }
            return largestLCM;
        }

        private static int calculateLCM(int a, int b) {
            return (a * b) / calculateGCD(a, b);
        }

        private static int calculateGCD(int a, int b) {
            if (b == 0)
                return a;
            return calculateGCD(b, a % b);
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int array_length = Integer.parseInt(scan.nextLine().trim());

            List<Integer> arr = new ArrayList<>(array_length);

            for (int j = 0; j < array_length; j++) {
                arr.add(Integer.parseInt(scan.nextLine().trim()));
            }

            int result = largestAdjacentLCM(array_length, arr);

            System.out.println(result);
        }
    }

