package nowcoder;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 合并k个已排序链表 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((x,
                                                                     y)->(x.val - y.val));
        for (ListNode head : lists) {
            if (head != null) queue.offer(head);
        }

        ListNode dummy  = new ListNode(0);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return dummy.next;

    }
}
