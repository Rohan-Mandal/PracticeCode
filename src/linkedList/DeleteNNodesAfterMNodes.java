package linkedList;

public class DeleteNNodesAfterMNodes {


    public static LinkedListNode2<Integer> skipMdeleteN(LinkedListNode2<Integer> head, int M, int N){
        if(M == 0){
            return null;
        }
        int count = 0;
        LinkedListNode2<Integer> currentNode = head;
        while(currentNode != null && currentNode.next != null){
            count++;
            int x = N;
            if(count == M){
                while(x > 0){
                    currentNode.next = currentNode.next.next;
                    if(currentNode == null){
                        return head;
                    }
                    count = 0;
                    x--;
                }
                x = N;
            }
            currentNode = currentNode.next;
        }
        return head;
    }
}
