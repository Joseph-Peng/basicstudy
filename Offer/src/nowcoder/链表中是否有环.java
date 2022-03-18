package nowcoder;

public class 链表中是否有环 {

    class ListNode{
        int val;
        ListNode next;
    }

    public boolean hasCycle(ListNode head){
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) return true;
        }
        return false;
    }
}
