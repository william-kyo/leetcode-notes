package linked.list;

import org.junit.Assert;

public class AddTwoNumbers {
    // My solution
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        // push stack
//        Stack<Integer> stack1 = new Stack<>();
//        Stack<Integer> stack2 = new Stack<>();
//        pushStack(l1, stack1);
//        pushStack(l2, stack2);
//
//        // pop stack accumulate to new result stack
//        Stack<Integer> stack;
//        if (stack1.size() >= stack2.size()) {
//            stack = accumulate(stack1, stack2);
//        } else {
//            stack = accumulate(stack2, stack1);
//        }
//
//        // change to ListNode
//        ListNode listNode = new ListNode(stack.pop());
//        while (!stack.empty()) {
//            listNode = new ListNode(stack.pop(), listNode);
//        }
//        return listNode;
//    }
//
//    private Stack<Integer> accumulate(Stack<Integer> g, Stack<Integer> l) {
//        Stack<Integer> stack = new Stack<>();
//        int accumulate = 0;
//        while (!g.empty()) {
//            int temp;
//            if (l.empty()) {
//                temp = g.pop() + accumulate;
//            } else {
//                temp = g.pop() + l.pop() + accumulate;
//            }
//
//            accumulate = temp / 10;
//            temp %= 10;
//            stack.push(temp);
//        }
//        if (accumulate > 0) {
//            stack.push(accumulate);
//        }
//        return stack;
//    }
//
//    private void pushStack(ListNode listNode, Stack<Integer> stack) {
//        if (listNode.next != null) {
//            pushStack(listNode.next, stack);
//        }
//        stack.push(listNode.val);
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        while (q != null || p != null) {
            int val1 = p == null ? 0 : p.val;
            int val2 = q == null ? 0 : q.val;
            int sum = val1 + val2 + carry;
            pre.next = new ListNode(sum % 10);
            pre = pre.next;
            carry = sum / 10;
            p = p == null ? p : p.next;
            q = q == null ? q : q.next;
        }
        if (carry > 0) {
            pre.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        /**
         * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
         * Output: 7 -> 0 -> 8
         */
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode actual = new AddTwoNumbers().addTwoNumbers(l1, l2);
        ListNode expected = new ListNode(7, new ListNode(0, new ListNode(8)));
        assertEquals(expected, actual);

        l1 = new ListNode(8, new ListNode(1));
        l2 = new ListNode(0);
        actual = new AddTwoNumbers().addTwoNumbers(l1, l2);
        expected = new ListNode(8, new ListNode(1));
        assertEquals(expected, actual);
    }

    private static void assertEquals(ListNode expected, ListNode actual) {
        if (expected == null) {
            Assert.assertNull(actual);
            return;
        }
        Assert.assertNotNull(actual);
        Assert.assertEquals(expected.val, actual.val);
        assertEquals(expected.next, actual.next);
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


