package PriorityQueue;
import java.util.*;

public class KLargestElement {

    public static void main(String[] args) {
        int [] array = {4, 1, 6, 3, 7, 2, 9, 8};
        int k = 4;
        printKLargest(array,k);
    }

    private static void printKLargest(int[] array, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            priorityQueue.add(array[i]);
        }

        for (int i = k; i < array.length ; i++) {
            if(priorityQueue.peek() < array[i]){
                priorityQueue.poll();
                priorityQueue.add(array[i]);
            }
        }
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
