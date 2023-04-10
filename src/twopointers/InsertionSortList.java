package twopointers;

class InsertionSortListNode {
    int val;
    InsertionSortListNode next;
    InsertionSortListNode(int x) { val = x; }
    InsertionSortListNode(int x, InsertionSortListNode next) { val = x; this.next = next; }
}

public class InsertionSortList {
    public InsertionSortListNode insertionSortList(InsertionSortListNode head) {
        InsertionSortListNode sentinel = new InsertionSortListNode(-1, head);
        InsertionSortListNode p = sentinel.next;
        while(p!=null) {
            InsertionSortListNode pTemp = p.next;
            InsertionSortListNode pre = sentinel;
            while(pre.next.val<p.val) {
                pre = pre.next;
            }
            if(pre.next!=p) {
                InsertionSortListNode preTemp = pre.next;
                pre.next = p;
                p.next = pre.next;
                pre = preTemp;
            }


            while(pre.next!=p) {
                pre = pre.next;
            }
            pre.next = pTemp;
            p = pTemp;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        InsertionSortList solution = new InsertionSortList();
        InsertionSortListNode head = new InsertionSortListNode(4, new InsertionSortListNode(2, new InsertionSortListNode(1, new InsertionSortListNode(3))));
        InsertionSortListNode p = solution.insertionSortList(head);
        while(p!=null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
