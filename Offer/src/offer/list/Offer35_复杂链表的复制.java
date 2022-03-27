package offer.list;

import java.util.HashMap;
import java.util.Map;

public class Offer35_复杂链表的复制 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 拼接拆分
     */
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        //拼接
        Node cur = head;
        while (cur!=null){
            Node next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }

        // 设置random节点
        cur = head;
        while (cur!=null){
            if (cur.random!=null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //拆分
        Node res = head.next, pre = head;
        cur = head.next;
        while (cur.next!=null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }

    public Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur!=null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

}
