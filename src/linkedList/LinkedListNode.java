package linkedList;

import java.io.IOException;
import java.util.Scanner;

public class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }

    static Scanner sc = new Scanner(System.in);

    public static LinkedListNode<Integer> takeUserInput(){

        int data = sc.nextInt();
        LinkedListNode<Integer> head = null, tail = null; // take head pointer reference
        while(data != -1){
            LinkedListNode<Integer> currentNode = new LinkedListNode<>(data);  // create new node with given data
            if(head == null){                               // check if there is any node present or nor  // if no node is present assign head with currentNode value
                head = currentNode;
                tail = currentNode;
            }
            else{
//                Node<Integer> tail = head;                  // check whose next is empty and add a node at the end of that node
//                while(tail.next != null){
//                    tail = tail.next;
//                }
                tail.next = currentNode;
                tail = currentNode;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public static void print(LinkedListNode<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        int t = Integer.parseInt(sc.next().trim());

        while (t > 0) {

            LinkedListNode<Integer> head = takeUserInput();
            int n = Integer.parseInt(sc.next().trim());

           // System.out.println(FindNode.findNodeRec(head, n));
            LinkedListNode<Integer> head1 = EvenAfterOdd.evenAfterOdd(head);
            print(head1);

            t -= 1;
        }

    }
}