package MaxPriorityQueue;

import java.util.ArrayList;

public class Max_Priority_Queue<T> {
    private ArrayList<Element<T>> heap;

    public Max_Priority_Queue(){
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority){
        Element<T> element = new Element<T>(value, priority);
        heap.add(element);

        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while(childIndex > 0){
            if(heap.get(childIndex).priority > heap.get(parentIndex).priority){
                Element<T> temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }
            else{
                return;
            }
            
        }

    }
    
    public T getMax() throws MaxPriorityQueueException{
        if(isEmpty()){
            throw new MaxPriorityQueueException();
        }
        return heap.get(0).value;
    }

    public T removeMax() throws MaxPriorityQueueException{
        if(isEmpty()){
            throw new MaxPriorityQueueException();
        }
        Element<T> remove = heap.get(0);
        T ans = remove.value;
        //removing the minimum element and putting the last element at 0th index
        heap.set(0, heap.get(heap.size() - 1));
        // removing the last element
        heap.remove(heap.size() - 1);

        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        while(leftChildIndex < heap.size()){
            int minIndex = parentIndex;
            if(heap.get(leftChildIndex).priority > heap.get(minIndex).priority){
                minIndex = leftChildIndex;
            }
            if(rightChildIndex < heap.size() && heap.get(leftChildIndex).priority > heap.get(minIndex).priority){
                minIndex = rightChildIndex;
            }
            //you have reached the correct place and don't need to move further downward 
            if(minIndex == parentIndex){
                break;
            }
            //swap the parentIndex element and minIndex element
            Element<T> temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);

            parentIndex = minIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;

        }
        return ans;
    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }
}
