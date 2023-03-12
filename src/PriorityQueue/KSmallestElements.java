package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallestElements {
    public static void main(String[] args) {
        int [] array = {2,12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        int k = 4;
        printKSmallest(array,k);
    }

    private static void printKSmallest(int[] array, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            priorityQueue.add(array[i]);
        }

        for (int i = k; i < array.length ; i++) {
            if(priorityQueue.peek() > array[i]){
                priorityQueue.poll();
                priorityQueue.add(array[i]);
            }
        }
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
