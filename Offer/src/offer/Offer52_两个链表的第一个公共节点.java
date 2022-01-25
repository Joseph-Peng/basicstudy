package offer;

public class Offer52_两个链表的第一个公共节点 {

    class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        // 当 A==null  且 B==null 退出循环
        while (A!=B){
            //之所以是A==null 而不是A.next==null 的原因是
            //可以理解为两条链表最后都指向了同一个 null （None）节点，代替了不相交的特殊情况。 非常的巧妙。
            A = A==null?headB:A.next;
            B = B==null?headA:B.next;
        }
        return A;
    }
}
