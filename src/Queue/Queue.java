package Queue;

public class Queue {
    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        // Implement the Constructor
        front = null;
        rear = null;
        size = 0;

    }

    /*----------------- Public Functions of Stack -----------------*/

    public int getSize() {
        // Implement the getSize() function
        return size;
    }

    public boolean isEmpty() {
        // Implement the isEmpty() function
        if (front == null) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(int data) {
        // Implement the enqueue(element) function
        Node newNode = new Node(data);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
        size++;
    }

    public int dequeue() {
        // Implement the dequeue() function
        if (front == null) {
            return -1;
        }
        int temp = front.data;
        front = front.next;
        size--;
        return temp;
    }

    public int front() {
        // Implement the front() function
        if (front == null) {
            return -1;
        } else {
            return front.data;
        }
    }
}
