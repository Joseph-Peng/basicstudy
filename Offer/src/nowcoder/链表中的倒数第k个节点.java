package nowcoder;

public class 链表中的倒数第k个节点 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode p = pHead;
        ListNode q = pHead;
        while (k>0 && q!=null){
            q = q.next;
            k--;
        }
        if (k>0) return null;
        while (q!=null){
            q = q.next;
            p = p.next;
        }
        return p;
    }
}
