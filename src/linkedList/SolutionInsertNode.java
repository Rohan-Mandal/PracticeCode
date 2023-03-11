package linkedList;

public class SolutionInsertNode {
    public static LinkedListNode1<Integer> insert(LinkedListNode1<Integer> head, int pos, int data){
        LinkedListNode1<Integer> newNode = new LinkedListNode1<Integer>(data);
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }
        int count = 0;
        LinkedListNode1<Integer> prev = head;
        while (count < pos - 1 && prev != null) {
            count++;
            prev = prev.next;
        }
        if (prev != null) {
            newNode.next = prev.next;
            prev.next = newNode;
        }
        return head;
    }
}
