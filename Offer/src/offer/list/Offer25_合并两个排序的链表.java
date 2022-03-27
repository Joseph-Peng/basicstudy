package offer.list;

public class Offer25_合并两个排序的链表 {

    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // 迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null || l2 == null) return l1==null?l2:l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1==null?l2:l1;
        return dummy.next;
    }

    // 递归
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if (l1 == null || l2 == null) return l1==null?l2:l1;
        if (l1.val>l2.val){
            l2.next = mergeTwoLists1(l1,l2.next);
            return l2;
        }else {
            l1.next = mergeTwoLists1(l1.next,l2);
            return l1;
        }
    }
}
