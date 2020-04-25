https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3309/

class LRUCache {
//     private Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
//     int size;
    
//     public LRUCache(int capacity) {
//         size = capacity;
//     }
    
//     public int get(int key) {
//         Integer value = map.remove(key);
//         if (value == null)
//             return -1;
//         map.put(key, value);
//         return value;
//     }
    
//     public void put(int key, int value) {
//         if (map.containsKey(key)) {
//             map.remove(key);
//         } else if (map.size() == size) {
//             Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
//             if (iterator.hasNext()) {
//                 iterator.next();
//                 iterator.remove();
//             }
//         }
//         map.put(key, value);
//     }
    
    private Map<Integer, Node> map = new HashMap<>();
    private Node head, tail;
    private int size;
    
    public LRUCache(int capacity) {
        size = capacity;
        head = tail = null;
    }
    
    public int get(int key) {
        Node valueNode = map.get(key);
        
        if (valueNode == null)
            return -1;
        
        if (valueNode != tail) {
            moveNodeToTail(valueNode);
        }
        
        return valueNode.val;
    }
    
    private void moveNodeToTail(Node valueNode) {
        if (valueNode == head) {
            head = head.next;
        }
            
        if (valueNode.next != null) {
            valueNode.next.prev = valueNode.prev;
        }
            
        if (valueNode.prev != null) {
            valueNode.prev.next = valueNode.next;
        }
            
        tail.next = valueNode;
        valueNode.prev = tail;
        valueNode.next = null;
        tail = tail.next;
    }
    
    public void put(int key, int value) {
        Node cacheNode = map.get(key);
        if (cacheNode != null) {
            cacheNode.val = value;
            if (cacheNode != tail) {
                moveNodeToTail(cacheNode);
            }
        } else {
            
            if (map.size() == size) {
                if (head.next != null) {
                    head.next.prev = head.prev;
                }
                
                Node removeNode = map.remove(head.key);
                head = head.next;
                removeNode.next = null;
                removeNode.prev = null;
            }
            
            Node node = new Node(key, value);
            map.put(key, node);
            
            if (head == null) {
                head = node;
            }
            
            if (tail == null) {
                tail = node;
            } else {
                node.prev = tail;
                tail.next = node;
                tail = tail.next;
            }
        }
    }
}

public class Node {
    public int val;
    public int key;
    public Node next;
    public Node prev;
    
    public Node(int key, int value) {
        this.key = key;
        this.val = value;
        this.next = null;
        this.prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
