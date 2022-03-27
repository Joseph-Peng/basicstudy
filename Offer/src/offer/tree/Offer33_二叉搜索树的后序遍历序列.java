package offer.tree;

import java.util.Deque;
import java.util.LinkedList;

public class Offer33_二叉搜索树的后序遍历序列 {

    //输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
    // 假设输入的数组的任意两个数字都互不相同。
    //思考：后序遍历    左右根
    public boolean verifyPostorder1(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i>=j) return true;
        int p = i;
        while (postorder[p]<postorder[j]) ++p;
        int left = p;
        while (postorder[p]>postorder[j]) ++p;

        return p==j && recur(postorder,i,left-1) && recur(postorder,left,j-1);
    }

    //单调栈的方式，通过逆后序遍历  根右左
    public boolean verifyPostorder(int[] postorder) {
        int root = Integer.MAX_VALUE;
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < postorder.length; ++i){
            if (postorder[i] > root) return false;
            // 如果当前节点大于栈顶节点说明还在根->右的逻辑，则需要继续压栈
            // 如果当前节点小于栈顶节点说明根右的逻辑已经遍历完成，来到了左子树
            while (!stack.isEmpty() && stack.peek()>postorder[i]){
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }

}
