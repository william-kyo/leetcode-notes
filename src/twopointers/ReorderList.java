package twopointers;

class ListNode {
    int val;
    InsertionSortListNode next;
    ListNode(int x) { val = x; }
}

public class ReorderList {
    public void reorderList(InsertionSortListNode head) {
        if(head==null) {
            return;
        }
        // find the pivot node
        InsertionSortListNode fast = head;
        InsertionSortListNode slow = head;
        while(fast.next!=null) {
            slow = slow.next;
            if(fast.next!=null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
        }
        // reverse linked list of the last half
        InsertionSortListNode pre = null;
        InsertionSortListNode p = slow.next;
        while(p!=null) {
            InsertionSortListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        // interweave the node
        InsertionSortListNode last = fast;
        slow.next = null;
        p = head;
        while(p!=null) {
            InsertionSortListNode temp = p.next;
            p.next = last;

            InsertionSortListNode lastTemp = last.next;
            last.next = temp;
            last = lastTemp;


            p = temp;
        }

    }

    public static void main(String[] args) {
        ReorderList solution = new ReorderList();
        InsertionSortListNode head = new InsertionSortListNode(1);
        InsertionSortListNode p = head;
        for(int i=2; i<=5; i++) {
            p.next = new InsertionSortListNode(i);
            p = p.next;
        }
        solution.reorderList(head);
        while(head!=null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
