class MyCircularDeque {

    private int[] deque;
    private int capacity;
    private int front;
    private int rear;
    private int count;

    public MyCircularDeque(int k) {
        capacity = k;
        deque = new int[capacity];
        front = 0;
        rear = capacity - 1;
        count = 0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        count++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        rear = (rear + 1) % capacity;
        deque[rear] = value;
        count++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % capacity;
        count--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        count--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return deque[front];
    }
    
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return deque[rear];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */