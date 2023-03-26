package random;

import java.util.Scanner;

public class OccurenceOfN {
        public static int findFreq(int N, int array_length, int[] arr) {
            int count = 0;
            for (int i = 0; i < array_length; i++) {
                if (arr[i] == N) {
                    count++;
                }
            }
            return count;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            int array_length = scanner.nextInt();
            int[] arr = new int[array_length];
            for (int i = 0; i < array_length; i++) {
                arr[i] = scanner.nextInt();
            }
            scanner.close();
            int freq = findFreq(N, array_length, arr);
            System.out.println(freq);
        }
    }
