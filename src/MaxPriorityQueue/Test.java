package MaxPriorityQueue;

public class Test {
    public static void main(String[] args) throws MaxPriorityQueueException{
        Max_Priority_Queue<String> myQueue = new Max_Priority_Queue<>();
        myQueue.insert("abc", 15);
        myQueue.insert("def", 13);
        myQueue.insert("ghi", 90);
        myQueue.insert("jkl", 150);
        myQueue.insert("mno", 120);

        while(!myQueue.isEmpty()){
            System.out.println(myQueue.getMax());
            myQueue.removeMax();
        }
    }
}
