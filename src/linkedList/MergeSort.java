package linkedList;

public class MergeSort {
    public static Node<Integer> mergeSort(Node<Integer> head){
        Node<Integer> partOneHead;
        Node<Integer> partTwoHead;

        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> mid = findMid(head);
        partOneHead = head;
        partTwoHead = mid.next;
        mid.next = null;

        Node<Integer> sortedHeadOne = mergeSort(partOneHead);
        Node<Integer> sortedHeadTwo = mergeSort(partTwoHead);
        Node<Integer> mergerHead = merge(sortedHeadOne, sortedHeadTwo);
        return mergerHead;
    }

    public static Node<Integer> findMid(Node<Integer> head){
        Node <Integer> slow = head;
        Node<Integer> fast = head;
        if(head == null || head.next == null){
            return head;
        }
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node<Integer> merge(Node<Integer> first, Node<Integer> second){
        Node<Integer> head = null;
        Node<Integer> tail = null;

        if(first == null){
            return second;
        }
        if(second == null){
            return first;
        }
        while (first != null && second != null){
            if (head == null && tail == null) {
                if(first.data < second.data){
                    head = first;
                    tail = first;
                    first = first.next;
                }
                else {
                    head = second;
                    tail = second;
                    second = second.next;
                }
            }
            else{
                if(first.data < second.data){
                    tail.next = first;
                    tail = tail.next;
                    first = first.next;
                }
                else{
                    tail.next = second;
                    tail = tail.next;
                    second = second.next;
                }
            }
        }
        if(first != null){
            tail.next = first;
        }
        else{
            tail.next = second;
        }
        return head;

    }

    public static void main(String[] args) {
        MainLinkedListUse obj = new MainLinkedListUse();
        Node<Integer> head1 = obj.takeUserInput();
        Node<Integer> head = mergeSort(head1);
        obj.print(head1);
    }
}
