package linkedList;

public class SolutionDeleteNode {
    public static LinkedListNode1<Integer> deleteNode(LinkedListNode1<Integer> head, int pos) {
        if(head == null ) {
            return head;
        }
        if(pos == 0) {
            return head.next;
        }
        int count = 0;
        LinkedListNode1<Integer> temp = head;
        while(temp != null && count < pos - 1)
        {
            temp=temp.next;
            count++;
        }
        if(temp == null)
            return head;
        if(temp.next != null)
            temp.next = temp.next.next;
        return head;
    }
}
