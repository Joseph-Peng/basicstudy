package codetop;

public class 重排链表 {

    class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head){
        if (head == null) return;
        // 1. 找到中点
        ListNode l1 = head;
        ListNode mid = findMid(l1);
        ListNode l2 = mid.next;
        mid.next = null;

        // 2. 翻转链表
        l2 = reverseList(l2);
        // 3. 合并链表
        mergeList(l1,l2);
    }

    private void mergeList(ListNode l1, ListNode l2) {
        while (l1!=null && l2!=null){
            ListNode t1 = l1.next;
            ListNode t2 = l2.next;

            l1.next = l2;
            l1 = t1;

            l2.next = l1;
            l2 = t2;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) return null;
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

    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 1 2 3 4 5
        // 1 2 3 4 5 6
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
