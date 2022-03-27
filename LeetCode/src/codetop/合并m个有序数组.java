package codetop;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 合并m个有序数组 {

    static class Node implements Comparable<Node> {
        int val;
        int index;
        int next;

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }

        public Node() {
        }

        public Node(int val, int index, int next) {
            this.val = val;
            this.index = index;
            this.next = next;
        }
    }

    //合并N个M长度的有序数组
    public static int[] mergeSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) return new int[0];
        if (arrays.length == 1) return arrays[0];

        int n = arrays.length;
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            queue.offer(new Node(arrays[i][0],i,1));
        }
        while (!queue.isEmpty()){
            Node node = queue.poll();
            list.add(node.val);
            if (node.next < arrays[node.index].length){
                queue.offer(new Node(arrays[node.index][node.next], node.index, node.next+1));
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i<list.size();++i){
            res[i] = list.get(i);
        }
        System.out.println(list);
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 4, 8, 9,100}, {2, 3, 6, 10}, {5, 18, 20, 36}};
        for (int num : mergeSortedArrays(nums)) {
            System.out.println(num);
        }
    }


}
