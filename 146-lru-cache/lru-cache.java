import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;
    private int size;
    private int capacity;
    private Map<Integer, DoublyLinkedListNode> map;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new DoublyLinkedListNode();
        this.tail = new DoublyLinkedListNode();
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        DoublyLinkedListNode current = map.get(key);

        // Move the accessed node to the head (most recently used)
        removeNode(current);
        addNodeAtHead(current);
        return current.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update the existing node
            DoublyLinkedListNode current = map.get(key);
            current.value = value;
            removeNode(current);
            addNodeAtHead(current);
        } else {
            // Check if cache is full
            if (size == capacity) {
                // Remove the least recently used node
                DoublyLinkedListNode lru = tail.previous;
                removeNode(lru);
                map.remove(lru.key); // Remove from map
                size--;
            }
            // Add the new node
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
            addNodeAtHead(newNode);
            map.put(key, newNode);
            size++;
        }
    }

    public void removeNode(DoublyLinkedListNode node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    public void addNodeAtHead(DoublyLinkedListNode node) {
        node.next = head.next;
        head.next.previous = node;
        head.next = node;
        node.previous = head;
    }
}

class DoublyLinkedListNode {

    public int key;
    public int value;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode previous;

    public DoublyLinkedListNode() {
    }

    public DoublyLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
