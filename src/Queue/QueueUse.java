package Queue;

public class QueueUse {
    public static void main(String[] args) {
        QueueArrayImplementation queue = new QueueArrayImplementation();
        int[] arr = {10, 20, 30, 40};
        for (int elements : arr) {
            try {
                queue.enqueuq(elements);
            } catch (QueueFullException e) {

            }
        }
        while(!queue.isEmpty()){
            try {
                System.out.println(queue.deueue());
            } catch (QueueEmptyException e) {

            }
        }
    }
}
