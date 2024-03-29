package Stack;
import java.io.*;
import java.util.*;
public class StockRunner {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws NumberFormatException, IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }

        String[] values = br.readLine().trim().split(" ");

        for(int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(values[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] input = takeInput();

        int[] output = SolutionStockSpan.stockSpan(input);

        printArray(output);

    }
}
