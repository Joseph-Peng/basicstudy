package offer.tree;

import java.util.Deque;
import java.util.LinkedList;

public class Offer36_二叉搜索树与双向链表 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head = null, pre = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        inorder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        inorder(root.right);
    }

    // 中序遍历非递归
    public Node treeToDoublyList1(Node root) {
        if (root == null) return root;
        Deque<Node> stack = new LinkedList<>();
        Node cur = root;
        Node pre = null, head = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre == null){
                    head = cur;
                }else {
                    pre.right = cur;
                }
                cur.left = pre;
                pre = cur;
                cur = cur.right;
            }
        }
        pre.right = head;
        head.left = pre;
        return head;
    }
}
