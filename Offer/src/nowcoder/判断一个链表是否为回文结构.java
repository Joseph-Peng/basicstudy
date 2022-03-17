package nowcoder;

public class 判断一个链表是否为回文结构 {

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public boolean isPail (ListNode head) {
        if (head == null) return false;
        // 快慢指针找中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast!=null) slow = slow.next;
        slow = reverseList(slow);
        fast = head;
        while (slow!=null){
            if (slow.val!=fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head){
        if (head == null) return head;
        ListNode pre = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
