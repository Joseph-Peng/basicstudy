package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Offer06_倒序输出链表 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    List<Integer> temp = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[temp.size()];
        for(int i = 0; i < temp.size(); ++i){
            res[i] = temp.get(i);
        }
        return res;
    }

    private void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        temp.add(head.val);
    }

    // stack
    public int[] reversePrint1(ListNode head) {
        if (head == null) return new int[0];
        ListNode cur = head;
        Stack<Integer> stack = new Stack<>();
        while (cur!=null){
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; ++i){
            res[i] = stack.pop();
        }
        return res;
    }
}
