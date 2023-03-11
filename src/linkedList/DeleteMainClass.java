package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LinkedListNode2<T> {
    T data;
    LinkedListNode2<Integer> next;

    public LinkedListNode2(T data) {
        this.data = data;
    }
}

public class DeleteMainClass {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static LinkedListNode2<Integer> takeInput() throws IOException {
        LinkedListNode2<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode2<Integer> newNode = new LinkedListNode2<>(data);
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

    public static void print(LinkedListNode2<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            LinkedListNode2<Integer> head = takeInput();
            String[] m_n = br.readLine().trim().split("\\s");

            int m = Integer.parseInt(m_n[0]);
            int n = Integer.parseInt(m_n[1]);

            LinkedListNode2<Integer> newHead = DeleteNNodesAfterMNodes.skipMdeleteN(head, m, n);
            print(newHead);

            t -= 1;
        }

    }
}
