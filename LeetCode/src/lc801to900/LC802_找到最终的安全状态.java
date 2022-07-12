package lc801to900;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC802_找到最终的安全状态 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        // 做逆向的拓扑排序，将出度为0的节点输出
        // 因为如果一个节点没有连出的有向边，则它是 终端节点
        int n = graph.length;
        int[] outDegree = new int[n];
        // 保存有边指向当前节点的节点id
        List<List<Integer>> preNode = new ArrayList<>();
        for(int i = 0; i < n; ++i) preNode.add(new LinkedList<>());
        for(int i = 0; i < n; ++i){
            for(int idx : graph[i]){
                outDegree[i]++;
                preNode.get(idx).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        //将出度为0的点加入队列
        for(int i = 0; i < n; ++i){
            if (outDegree[i] == 0){
                queue.offer(i);
            }
        }
        List<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for(int idx : preNode.get(node)){
                outDegree[idx]--;
                if(outDegree[idx] == 0){
                    queue.offer(idx);
                }
            }
        }
        res.sort((a, b) -> a - b);
        return res;
    }
}
