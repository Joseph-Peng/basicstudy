package nowcoder;

public class 链表指定区间内翻转 {

    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pm = dummy;
        ListNode pn = dummy;
        while (m>1){
            pm = pm.next;
            m--;
        }
        ListNode pre = pm; // 记录翻转区间的前一个节点，便于后面连接
        pm = pm.next;
        while (n>0){
            pn = pn.next;
            n--;
        }
        ListNode next = pn.next; // 记录翻转区间的下一个节点，便于后面连接
        pn.next = null;
        pre.next = reverse(pm);
        pm.next = next;
        return dummy.next;
    }

    private ListNode reverse(ListNode pm) {
        ListNode pre = null;
        ListNode cur = pm;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pm;
    }
}
