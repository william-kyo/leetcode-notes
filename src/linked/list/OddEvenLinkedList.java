package linked.list;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        int count = 1;
        ListNode last = head;
        ListNode p = head;
        while (p != null) {
            // odd
            if ((count & 1) == 1 && count > 1) {
                ListNode temp = odd.next;
                odd.next = p;
                last.next = p.next;
                p.next = temp;
                odd = odd.next;
                p = last;
            } else {
                last = p;
                p = p.next;
            }

            count++;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = createListNode(new int[]{1, 2, 3, 4, 5});
        OddEvenLinkedList oddEven = new OddEvenLinkedList();
        ListNode actual = oddEven.oddEvenList(head);
        System.out.println(actual);
    }

    private static ListNode createListNode(int[] nodes) {
        ListNode sentinel = new ListNode(-1);
        ListNode p = sentinel;
        for (int n : nodes) {
            p.next = new ListNode(n);
            p = p.next;
        }
        return sentinel.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
