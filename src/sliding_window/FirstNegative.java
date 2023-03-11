package sliding_window;

import java.util.*;

public class FirstNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 8;
        int k = 3;
        long[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        //long[] arr = new long[n];

        /*for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }*/

        System.out.println(Arrays.toString(findNegative(arr, k)));
    }

    public static long[] findNegative(long[] arr, int K) {
        Queue<Long> que = new LinkedList<>();
        long[] result = new long[arr.length - K + 1];
        int i = 0, j = 0;
        int index = 0;
        while (j < arr.length) {
            if (arr[j] < 0) {
                que.add(arr[j]);
            }

            if (j - i + 1 == K) {
                if (que.size() == 0) {
                    result[index++] = 0;
                } else {
                    result[index++] = que.peek();
                    if (arr[i] == que.peek()) {
                        que.poll();
                    }
                }
                i++;
            }
            j++;
        }
        return result;
    }
}
