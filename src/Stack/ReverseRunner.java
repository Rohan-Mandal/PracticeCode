package Stack;
import java.io.*;
import java.util.*;
public class ReverseRunner {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Stack<Integer> takeInput() throws NumberFormatException, IOException {
        int size = Integer.parseInt(br.readLine().trim());
        Stack<Integer> input = new Stack<>();

        if (size == 0) {
            return input;
        }

        String[] values = br.readLine().trim().split(" ");

        for(int i = 0; i < size; i++) {
            input.push(Integer.parseInt(values[i]));
        }

        return input;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Stack<Integer> input = takeInput();
        Stack<Integer> empty = new Stack<>();

        ReverseStackSolution.reverseStack(input, empty);

        while(!input.isEmpty()) {
            System.out.print(input.pop() + " ");
        }

    }
}
