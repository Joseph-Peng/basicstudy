package codetop;

public class 删除链表的倒数第n个节点 {

    public class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        while(n>0 && p!=null){
            p = p.next;
            n--;
        }
        if(p==null) return head.next;
        while (p.next!=null){
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }
}
