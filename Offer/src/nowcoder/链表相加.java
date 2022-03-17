package nowcoder;

import java.util.List;
import java.util.Stack;

public class 链表相加 {
    class ListNode{
        int val;
        ListNode next = null;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addInList(ListNode head1, ListNode head2){
        if (head1==null || head2 == null) return head1 == null ? head2 : head1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1!=null){
            s1.push(head1.val);
            head1 = head1.next;
        }
        while (head2!=null){
            s2.push(head2.val);
            head2 = head2.next;
        }

        int carry = 0;
        ListNode dummyHead = new ListNode(1);
        while (!s1.isEmpty() || !s2.isEmpty()){
            int val1 = s1.isEmpty()? 0 : s1.pop();
            int va12 = s2.isEmpty()? 0 : s2.pop();
            int sum = val1 + va12 + carry;
            carry = sum/10;
            sum = sum%10;
            ListNode node = new ListNode(sum);
            node.next = dummyHead.next;
            dummyHead.next = node;
        }
        if (carry!=0){
            ListNode node = new ListNode(carry);
            node.next = dummyHead.next;
            dummyHead.next = node;
        }

        return dummyHead.next;
    }
}
