package PriorityQueue.HeapSort;

public class HeapSort {

    public static void downHeapify(int[] array, int i, int n){
        int parentIndex = i;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        while(leftChildIndex < n){
            int minIndex = parentIndex;
            if(array[leftChildIndex] < array[minIndex]){
                minIndex = leftChildIndex;
            }
            if(rightChildIndex < n && array[rightChildIndex] < array[minIndex]){
                minIndex = rightChildIndex;
            }

            if(minIndex == parentIndex){
                return;
            }

            int temp = array[parentIndex];
            array[parentIndex] = array[minIndex];
            array[minIndex] = temp;

            parentIndex = minIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }

    }
    public static void heapSort(int[] array){
        //build the heap
        int length = array.length;
        for (int i = (length / 2); i >= 0 ; i--) {
            downHeapify(array, i, length);
        }
        //Remove elements from starting one by one and them put them at respective last position

        for (int i = length - 1; i >= 0 ; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downHeapify(array, 0, i);
        }
    }

    public static void main(String[] args) {

        int [] array = {4, 7, 3, 2, 8, 9, 6, 1};
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
