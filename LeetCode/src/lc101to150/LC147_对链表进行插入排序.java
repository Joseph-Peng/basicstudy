package lc101to150;

public class LC147_对链表进行插入排序 {

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

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode lastSorted = head, cur = head.next;
        while (cur!=null){
            if (lastSorted.val<=cur.val){
                lastSorted = lastSorted.next;
            }else {
                ListNode prev = dummy;
                while (prev.next.val <= cur.val){
                    prev = prev.next;
                }
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummy.next;
    }
}
