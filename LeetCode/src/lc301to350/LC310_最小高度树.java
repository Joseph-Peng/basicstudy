package lc301to350;

import java.util.*;

public class LC310_最小高度树 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Arrays.asList(0);
        // 1. 统计每个节点的入度，和与它有连边的节点
        int[] inDegree = new int[n];
        List<List<Integer>> outDegree = new ArrayList<>();
        for(int i = 0; i < n; ++i) outDegree.add(new LinkedList<>());

        for (int[] edge : edges){
            int a = edge[0], b = edge[1];
            inDegree[a]++;
            inDegree[b]++;
            outDegree.get(a).add(b);
            outDegree.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        //boolean[] visited = new boolean[n];
        for(int i = 0; i<n; ++i){
            if(inDegree[i] == 1){
                queue.offer(i);
                //visited[i] = true;
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()){
            res = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                res.add(node);
                for(int idx : outDegree.get(node)){
                    //if (!visited[idx]){
                        inDegree[idx]--;
                        if (inDegree[idx] == 1){
                            //visited[idx] = true;
                            queue.offer(idx);
                        }
                   // }
                }
            }
        }
        return res;
    }
}
