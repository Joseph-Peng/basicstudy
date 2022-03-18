package nowcoder;

public class 单链表排序 {

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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);

        ListNode res = mergeLsit(l1,l2);
        return res;
    }

    private ListNode mergeLsit(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1==null?l2:l1;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (l1!=null && l2!=null){
            if (l1.val>l2.val){
                temp.next = l2;
                l2 = l2.next;
            }else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }

        temp.next = l1==null?l2:l1;
        return dummy.next;
    }
}
