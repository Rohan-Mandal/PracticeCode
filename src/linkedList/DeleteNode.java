package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LinkedListNode1<T> {
    T data;
    LinkedListNode1<T> next;

    public LinkedListNode1(T data) {
        this.data = data;
    }
}

public class DeleteNode {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static LinkedListNode1<Integer> takeInput() throws IOException {
        LinkedListNode1<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode1<Integer> newNode = new LinkedListNode1<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }

    public static void print(LinkedListNode1<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            LinkedListNode1<Integer> head = takeInput();

            int pos = Integer.parseInt(br.readLine().trim());
            head = SolutionDeleteNode.deleteNode(head, pos);
            print(head);

            t -= 1;
        }
    }
}