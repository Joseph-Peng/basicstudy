package lc000to050;

public class LC19_删除链表中的倒数第N个节点 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(){}

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // n=3
    // dummy  1 2 3 4 5 6 null
    //     s        f
    //            s       f
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummy;
        for(int i = 0; i<n; ++i){
            first = first.next;
        }
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
