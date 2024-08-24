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
        head.setNext(tail);
        tail.setPrevious(head);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        DoublyLinkedListNode current = map.get(key);

        // Move the accessed node to the head (most recently used)
        removeNode(current);
        addNodeAtHead(current);
        return current.getValue();
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update the existing node
            DoublyLinkedListNode current = map.get(key);
            current.setValue(value);
            removeNode(current);
            addNodeAtHead(current);
        } else {
            // Check if cache is full
            if (size == capacity) {
                // Remove the least recently used node
                DoublyLinkedListNode lru = tail.getPrevious();
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
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
    }

    public void addNodeAtHead(DoublyLinkedListNode node) {
        node.setNext(head.getNext());
        node.getNext().setPrevious(node); // Set the previous of the next node
        head.setNext(node);
        node.setPrevious(head);
    }
}

class DoublyLinkedListNode {

    int key;
    private int value;
    private DoublyLinkedListNode next;
    private DoublyLinkedListNode previous;

    public DoublyLinkedListNode() {
    }

    public DoublyLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setNext(DoublyLinkedListNode next) {
        this.next = next;
    }

    public DoublyLinkedListNode getNext() {
        return this.next;
    }

    public void setPrevious(DoublyLinkedListNode previous) {
        this.previous = previous;
    }

    public DoublyLinkedListNode getPrevious() {
        return this.previous;
    }
}
