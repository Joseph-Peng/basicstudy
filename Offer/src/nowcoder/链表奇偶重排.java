package nowcoder;

public class 链表奇偶重排 {

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode cur = l2;
        while (l1.next!=null && cur.next!=null){
            l1.next = l1.next.next;
            cur.next = cur.next.next;

            l1 = l1.next;
            cur = cur.next;
        }

        l1.next = l2;
        return head;
    }
}
