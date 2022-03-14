package lc101to150;

public class LC142_环形链表的环入口 {

    class ListNode{
        int val;
        ListNode next;
    }

    public ListNode detectCycle(ListNode head){
        ListNode fast = head, slow = head;
        while (true){
            if (fast == null || fast.next==null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                break;
            }
        }
        // 证明一定有环
        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
