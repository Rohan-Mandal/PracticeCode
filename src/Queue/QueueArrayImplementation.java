package Queue;

public class QueueArrayImplementation {
    private int[] data;
    private int front;
    private int rear;
    private int size;


    public QueueArrayImplementation() {
        data = new int[5];
        front = -1;
        rear = -1;
    }

    public QueueArrayImplementation(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueuq(int element) throws QueueFullException {
        if(size == data.length){
//            throw new QueueFullException();
            doubleCapacity();
        }
        if(front == -1){
            front++;
        }
//        rear++;
//        if(rear == data.length){
//            rear = 0;
//        }
        rear = (rear + 1) % data.length;
        data[rear] = element;
        size++;
    }

    public int front() throws QueueEmptyException {
        if(size == 0){
            throw new QueueEmptyException();
        }
        return data[front];
    }

    public int deueue() throws QueueEmptyException{
        if(size == 0){
            throw new QueueEmptyException();
        }
//        front++;
//        if(front == data.length){
//            front = 0;
//        }
        front = (front + 1) % data.length;
        int temp = data[front];
        size--;
        if(front == rear){
            front = -1;
            rear = -1;
        }
        return temp;
    }
    public void doubleCapacity(){
        int[] temp = data;
        data = new int[2 * temp.length];
        int index = 0;
        for (int i = front; i < temp.length; i++) {
            data[index++] = temp[i];
        }
        for (int i = 0; i < front - 1; i++) {
            data[index++] = temp[i];
        }
        front = 0;
        rear = temp.length - 1;
    }

}
