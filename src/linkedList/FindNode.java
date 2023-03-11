package linkedList;

public class FindNode {


    public static int findNodeRec(LinkedListNode<Integer> head, int n) {

        LinkedListNode<Integer> tail = head;
        if(head == null){
            return -1;
        }
        if((head == null || head.next == null) && head.data != n){
            return -1;
        }
        if(head.data.equals(n)){
            return 0 ;
        }
        int smallIndex;
        smallIndex = findNodeRec(tail.next, n);
        if(smallIndex == -1){
            return smallIndex;
        }
        else{
            return smallIndex+1;
        }
    }
}
