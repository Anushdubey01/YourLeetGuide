import java.util.HashMap;
import java.util.Map;

class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}

class LRUCache {
    private Map<Integer, Node> cacheMap;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addNode(Node newNode) {
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key))
            return -1;

        Node node = cacheMap.get(key);
        deleteNode(node);
        addNode(node);
        cacheMap.put(key, head.next);
        return head.next.val;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            deleteNode(node);
            node.val = value;
            addNode(node);
            cacheMap.put(key, head.next);
        } else {
            if (cacheMap.size() == capacity) {
                Node prev = tail.prev;
                deleteNode(prev);
                Node newNode = new Node(key, value);
                addNode(newNode);
                cacheMap.remove(prev.key);
                cacheMap.put(key, head.next);
            } else {
                Node newNode = new Node(key, value);
                addNode(newNode);
                cacheMap.put(key, head.next);
            }
        }
    }
}