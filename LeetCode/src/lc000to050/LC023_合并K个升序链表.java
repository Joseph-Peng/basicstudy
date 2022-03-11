package lc000to050;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC023_合并K个升序链表 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists){
        if (lists==null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        for (ListNode node : lists){
            if (node!=null) queue.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next!=null){
                queue.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
