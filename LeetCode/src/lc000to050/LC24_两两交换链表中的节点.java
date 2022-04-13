package lc000to050;

import java.util.List;

public class LC24_两两交换链表中的节点 {

    class ListNode{
        int val;
        ListNode next;

        public ListNode(){}

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next!=null && cur.next.next!=null){
            ListNode pre = cur.next;
            ListNode end = cur.next.next;
            ListNode temp = end.next;
            end.next = pre;
            pre.next = temp;
            cur.next = end;
            cur = pre;
        }

        return dummy.next;
    }

}
