package linked.list;

import org.junit.Assert;

public class RemoveNthNode {
    private ListNode point = null;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        flipNode(sentinel, n);
        if (point != null) {
            ListNode temp = null;
            if (point.next != null) {
                temp = point.next.next;
            }
            point.next = temp;
        }

        return sentinel.next;
    }

    private int flipNode(ListNode node, int n) {
        if (node == null) {
            return 0;
        }
        int cur = flipNode(node.next, n) + 1;
        if (cur == n + 1) {
            point = node;
        }
        return cur;
    }


    public static void main(String[] args) {
        RemoveNthNode rnn = new RemoveNthNode();

        ListNode head, expected, actual;
        int n;

        n = 1;
        head = createListNode(new int[]{1, 2});
        expected = createListNode(new int[]{1});
        actual = rnn.removeNthFromEnd(head, n);
        Assert.assertTrue(assertTwoListNodes(expected, actual));

        n = 2;
        head = createListNode(new int[]{1, 2, 3, 4, 5});
        expected = createListNode(new int[]{1, 2, 3, 5});
        actual = rnn.removeNthFromEnd(head, n);
        Assert.assertTrue(assertTwoListNodes(expected, actual));

    }

    private static boolean assertTwoListNodes(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return true;
        }
        if (l1 == null || l2 == null) {
            return false;
        }
        if (l1.val == l2.val) {
            return assertTwoListNodes(l1.next, l2.next);
        }
        return false;
    }

    private static ListNode createListNode(int[] arr) {
        ListNode sentinel = new ListNode(-1);
        ListNode p = sentinel;
        for (int a : arr) {
            ListNode temp = new ListNode(a);
            p.next = temp;
            p = temp;
        }
        return sentinel.next;
    }

    private static class ListNode {
        int val;
        RemoveNthNode.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, RemoveNthNode.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
