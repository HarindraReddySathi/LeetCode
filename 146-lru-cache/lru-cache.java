import java.util.HashMap;
import java.util.Map;

class LRUCache {

    int capacity;
	int size;
	Map<Integer,Node> map;
	Node head;
	Node tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.size =0;
		this.map = new HashMap<>();
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		
	}
	
	/// public int get(int key) throws Exception{
	
	public int get(int key) {
		
		//if(!map.containsKey(key)) throw new Exception();
		
		if(!map.containsKey(key)) return -1;
		
		Node current = map.get(key);
		deleteNode(current);
		addNodeToHead(current);
		return current.value;
		
    }

    public void put(int key, int value) {
    	
    	if(map.containsKey(key)) {
    		Node current = map.get(key);
    		deleteNode(current);
    		addNodeToHead(current);
    		current.value = value;

    	}else {
    		Node current = new Node(key,value);
            map.put(key,current);
    		addNodeToHead(current);
    		size++;
    		if(size>capacity) {
    			map.remove(tail.prev.key);
    			deleteNode(tail.prev);
    			size--;
    		}
    		
    	}
    }
    
    private void addNodeToHead(Node node) {
    	Node temp = head.next;
    	head.next = node;
    	node.next = temp;
    	node.prev = head;
    	temp.prev = node;
    }
    
    private void deleteNode(Node node) {
    	Node temp = node.next;
    	node.prev.next = temp;
    	temp.prev = node.prev;
    }
	

}

class Node{
	
	public int key;
	public int value;
	public Node next;
	public Node prev;
	
	public Node(int key,int value) {
		this.key = key;
		this.value = value;
	}

	public Node() {}
	
}
