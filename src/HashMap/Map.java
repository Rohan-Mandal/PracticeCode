import java.util.*;
public class Map<K, V> {
    ArrayList<MapNOde<K, V>> buckets;
    int count;
    int numBuckets;

    public Map(){
        buckets = new ArrayList<>();
        numBuckets = 20;
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }

    public int getBucketIndex(K key){
        int myHashCode = key.hashCode();
        int index = myHashCode % numBuckets;
        return index;
    }

    public int size(){
        return count;
    }

    public V remove(K key){
        int bucketIndex = getBucketIndex(key);
        MapNOde<K, V> head = buckets.get(bucketIndex);
        MapNOde<K, V> prev = null;

        while(head != null){
            if(head.key.equals(key)){
                if(prev != null){
                    prev.next = head.next;
                }
                else{
                    buckets.set(bucketIndex, head.next);
                }
                
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);
        MapNOde<K, V> head = buckets.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void insert(K key, V value){
        int bucketIndex = getBucketIndex(key);
        MapNOde<K, V> head = buckets.get(bucketIndex);
        // check if element is already there
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        // element not found, insert at 0th position linked list

        head = buckets.get(bucketIndex);
        MapNOde<K, V> newNode = new MapNOde<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;
    }
}
