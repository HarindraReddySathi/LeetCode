import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

    private int capacity;
    private Map<Integer, Integer> map; // Key to value mapping
    private LinkedList<Integer> list; // Tracks the order of usage

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1; // Key is not present in cache
        }

        // Move the accessed key to the front (most recently used)
        list.remove((Integer) key); // Remove the key from its current position
        list.addFirst(key); // Add it to the front
        return map.get(key); // Return the value associated with the key
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // If the key exists, update its value and move it to the front
            map.put(key, value);
            list.remove((Integer) key); // Remove the key from its current position
            list.addFirst(key); // Add it to the front
        } else {
            // If the key does not exist and the cache is full, evict the LRU item
            if (list.size() == capacity) {
                int lruKey = list.removeLast(); // Remove the last item (LRU)
                map.remove(lruKey); // Remove the LRU key from the map
            }
            // Add the new key-value pair
            map.put(key, value);
            list.addFirst(key); // Add the key to the front (most recently used)
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
