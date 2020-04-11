https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3292/

class MinStack {
    private Node head;

    /** initialize your data structure here. */
    public MinStack() {
        head = null;
    }
    
    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.currentMin), head);
        }
    }
    
    public void pop() {
        head = head.prev;
    }
    
    public int top() {
        if (head != null)
            return head.value;
        
        return 0;
    }
    
    public int getMin() {
        if (head != null)
            return head.currentMin;
        
        return 0;
    }
}

class Node {
    public int value;
    public Node prev;
    public int currentMin;
    
    public Node(int value, int currentMin, Node prev) {
        this.value = value;
        this.prev = prev;
        this.currentMin = currentMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
