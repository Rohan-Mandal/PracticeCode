public class MapNOde<K,V> {
    K key;
    V value;
    MapNOde<K, V> next;

    public MapNOde(K key, V value){
        this.key = key;
        this.value = value;
    }
    
}
