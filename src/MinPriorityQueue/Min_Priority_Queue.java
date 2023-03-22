package MinPriorityQueue;
import java.util.*;

public class Min_Priority_Queue<T> {
     
    private ArrayList<Element<T>> heap;

    public Min_Priority_Queue(){
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority){
        Element<T> element = new Element<T>(value, priority);
        heap.add(element);

        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        
        // swapping the elements at [parentIndex] and [childIndex] to maintain the priority order of the complete binary tree
        // repeat the process untill all the nodes are following the CBT as well as the priority order
        // stop either when you have reached the root i.e top of the tree or at the node where its parent node has smaller value
        while(childIndex > 0){
            if(heap.get(childIndex).priority < heap.get(parentIndex).priority){
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

    public T getMin() throws PriorityQueueException{
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        return heap.get(0).value;
    }

    public T removeMin() throws PriorityQueueException{
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        // Storing the last element //
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
            if(heap.get(leftChildIndex).priority < heap.get(minIndex).priority){
                minIndex = leftChildIndex;
            }
            if(rightChildIndex < heap.size() && heap.get(leftChildIndex).priority < heap.get(minIndex).priority){
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
