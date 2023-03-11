package linkedList;

public class EvenAfterOdd {

    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
        if(head ==  null || head.next == null){
            return head;
        }
        LinkedListNode<Integer> node= head, evenNode = null, oddNode = null, oddHead = null, evenHead = null;
        while (node != null){
            int data = node.data;
            if(data % 2 == 0){
                if(evenNode == null){
                    evenNode = node;
                    evenHead = node;
                }
                else{
                    evenNode.next = node;
                    evenNode = evenNode.next;
                }
            }
            else{
                if(oddNode == null){
                    oddNode = node;
                    oddHead = node;
                }
                else{
                    oddNode.next = node;
                    oddNode = oddNode.next;
                }
            }
            node = node.next;
        }
        if(oddHead == null){
            return evenHead;
        }
        else{
            oddNode.next = evenHead;
        }
        if(evenNode != null){
            evenNode.next = null;
        }
        return oddHead;
    }
}
