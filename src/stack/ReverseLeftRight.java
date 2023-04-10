package stack;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

class ListNode {

    int val;

    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

public class ReverseLeftRight {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        int count = 0;
        ListNode p = dummy;
        ListNode leftNode = null;
        Deque<Integer> deque = new LinkedList<>();
        while (count <= right) {
            if (count == left) {
                leftNode = p;
            }
            if (count >= left) {
                deque.offerLast(p.val);
            }
            p = p.next;
            count++;
        }

        p = leftNode;
        while (!deque.isEmpty()) {
            p.val = deque.pollLast();
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ReverseLeftRight solution = new ReverseLeftRight();
        ListNode reversed = solution.reverseBetween(head, 2, 4);
        int[] expected = new int[]{1, 4, 3, 2, 5};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], reversed.val);
            reversed = reversed.next;
        }
    }
}
