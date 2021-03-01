public class CustomStack {
    private Node root;
    private Node bottom;
    private int size;
    private int maxSize;
    private static final Object lock = new Object();

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
    }

    public void push(int x) {
        if (size == maxSize) {
            return;
        }
        synchronized (lock) {
            size += 1;
            Node node = new Node(x);
            node.next = root;
            if (size == 1) {
                bottom = node;
            } else {
                root.pre = node;
            }
            root = node;
        }
    }

    public int pop() {
        int x;
        synchronized (lock) {
            if (size == 0) {
                return -1;
            }
            size -= 1;
            x = root.val;
            root = root.next;
        }
        return x;
    }

    public void increment(int k, int val) {
        Node p = bottom;
        int count = k;
        while (p != null && count-- > 0) {
            p.val += val;
            p = p.pre;
        }
    }

    private class Node{
        int val;
        Node next;
        Node pre;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        CustomStack customStack = new CustomStack(3); // Stack is Empty []
        customStack.push(1);                          // stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.push(3);                          // stack becomes [1, 2, 3]
        customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
        customStack.increment(5, 100);                // stack becomes [101, 102, 103]
        customStack.increment(2, 100);                // stack becomes [201, 202, 103]
        customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
        customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
        customStack.pop();                            // return -1 --> Stack is empty return -1.
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
