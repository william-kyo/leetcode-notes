package sort;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}

public class MergeSortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // cut the list into half
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // sort left list, sort right list
        ListNode l = sortList(head);
        ListNode r = sortList(slow);

        // merge list
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode ret = new ListNode(-1);
        ListNode p = ret;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = (l != null) ? l : r;
        return ret.next;
    }



    public static void main(String[] args) {
        MergeSortList solution = new MergeSortList();
        // head = [4,2,1,3]
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode p = solution.sortList(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
        // head = [-1,5,3,4,0]
        head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        p = solution.sortList(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
        // head = []
        head = null;
        p = solution.sortList(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
