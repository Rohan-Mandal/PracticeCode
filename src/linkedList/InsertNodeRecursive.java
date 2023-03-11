package linkedList;

import java.util.Scanner;

public class InsertNodeRecursive {

    public static Node<Integer> insertRecursive(Node<Integer>head, int element, int pos){

        if(pos == 0){
            Node<Integer> newNode = new Node<>(element);
            newNode.next = head;
            return newNode;
        }
        if(head == null && pos > 0){
            return head;
        }
        else{
            Node<Integer> smallerHead = insertRecursive(head.next, element, pos - 1);
            head.next = smallerHead;
            return head;
        }
    }
    /*public static Node<Integer> reverseRecursive(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }*/

    public static Node<Integer> reverseRecursive(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> newHead = reverseRecursive(head.next);
        Node<Integer> tail = newHead;
        while (tail.next != null){
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;
        return newHead;

    }
    public static Node<Integer> takeUserInput(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null, tail = head; // take head pointer reference
        while(data != -1){
            Node<Integer> currentNode = new Node<>(data);  // create new node with given data
            if(head == null ){                               // check if there is any node present or nor  // if no node is present assign head with currentNode value
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
    public static void print(Node<Integer> head){
        Node<Integer> temp = head;

        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node<Integer> head = takeUserInput();
      //  head = insertRecursive(head, 30, 9);
        head = reverseRecursive(head);
        print(head);


    }
}
