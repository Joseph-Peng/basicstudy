package lc201to300;

public class LC234_回文链表 {

    class ListNode{
        int val;
        ListNode next;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        // 1 2 3 4 5
        // 1 2 3 4 5 6
        while (fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail =  reverse(slow.next);
        ListNode p1 = head;
        ListNode p2 = tail;
        boolean result = true;
        while (result && p2 != null){
            if(p1.val != p2.val){
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 还原链表
        slow.next = reverse(tail);
        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
