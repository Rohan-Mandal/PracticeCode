package linkedList;

import java.util.Scanner;

public class MainLinkedListUse {


    public static Node<Integer> createNodes(){
        Node<Integer> node = new Node<>(10);
        Node<Integer> node1 = new Node<>(20);
        Node<Integer> node2 = new Node<>(30);
        Node<Integer> node3 = new Node<>(40);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        return node;
    }

    /*    public static void noobStylePrint(Node<Integer> head){
            System.out.println(head.data);
            System.out.println(head.next.data);
            System.out.println(head.next.next.data);
            System.out.println(head.next.next.next.data);
        }*/
    public static void print(Node<Integer> head){
        Node<Integer> temp = head;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void increment(Node<Integer> head){
        Node<Integer> temp = head;
        while(temp != null){
            temp.data++;
            temp = temp.next;
        }
        System.out.println();
    }

    //take LinkedList input from the user
    public static Node<Integer> takeUserInput(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null, tail = null; // take head pointer reference
        while(data != -1){
            Node<Integer> currentNode = new Node<>(data);  // create new node with given data
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
    public static Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> list1, Node<Integer> list2) {
        //Your code goes here
        Node<Integer> head = null;
        Node<Integer> tail = null;
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        while(list1 != null && list2 != null){

            if(head == null && tail == null){
                if(list1.data > list2.data){
                    head = list2;
                    tail = list2;
                    list2 = list2.next;
                }else{
                    head = list1;
                    tail = list1;
                    list1 = list1.next;
                }
            }
            else {
                if(list1.data < list2.data){
                    tail.next = list1;
                    tail = tail.next;
                    list1 = list1.next;
                }
                else{
                    tail.next = list2;
                    tail = tail.next;
                    list2 = list2.next;
                }
            }
        }

        if(list1 != null){
            tail.next = list1;
        }
        if(list2 != null){
            tail.next = list2;
        }
        return head;
    }

    public static void main(String[] args) {
       /* Node<Integer> node = new Node<>(10);
        System.out.println(node.data);
        System.out.println(node.next);*/
        // Node<Integer> head = createNodes();
        Node<Integer> head1 = takeUserInput();
        Node<Integer> head2 = takeUserInput();
        Node<Integer> head = mergeTwoSortedLinkedLists(head1, head2);
        // noobStylePrint(head);
        // increment(head);
        print(head);


    }
}
