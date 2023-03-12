package PriorityQueue;

import java.util.*;
import java.io.*;

public class Kth_Largest_Element {
    public static int kthLargest(int n, int[] input, int k) {
        // Write your code here
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            priorityQueue.add(input[i]);
        }

        for (int i = k; i < input.length ; i++) {
            if(priorityQueue.peek() < input[i]){
                priorityQueue.poll();
                priorityQueue.add(input[i]);
            }
        }

        int minValue = Integer.MAX_VALUE;
        while(!priorityQueue.isEmpty())
        {
            int check = priorityQueue.poll();
            if(check < minValue){
                minValue = check;
            }
        }
        return minValue;

    }
}

class MyMain {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int input[] = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(Kth_Largest_Element.kthLargest(n, input, k));
    }
}
