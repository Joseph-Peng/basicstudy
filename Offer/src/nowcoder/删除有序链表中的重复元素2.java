package nowcoder;

public class 删除有序链表中的重复元素2 {

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates (ListNode head) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            if(cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next!=null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

}
