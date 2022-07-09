package graph;

import java.util.PriorityQueue;

/**
 * 最小生成树
 */
public class Kruskal {

    /**3
     *
     * @param edges 起始点(edges[0])，终点(edges[1])，权值(edges[2])
     * @param n 节点的个数
     */
    public int kruskal(int[][] edges, int n){
        UnionFind set = new UnionFind(n);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int[] edge : edges){
            int a = edge[0], b = edge[1], w = edge[2];
            queue.add(new int[]{a, b, w});
        }

        int ans = 0;
        while (!queue.isEmpty()){
            int[] edge = queue.poll();
            int a = edge[0], b = edge[1], w = edge[2];
            if(set.find(a) != set.find(b)){
                set.union(a,b);
                ans += w;
            }
        }
        return ans;
    }

    public class UnionFind {

        int[] parent, rank;
        int size;
        int nums;

        public UnionFind(int size) {
            this.size = size;
            nums = size;
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if(parent[x] == x) return x;
            else{
                parent[x] = find(parent[x]);
                return parent[x];
            }
            // 可以简化为下面一句
            // return x == parent[x] ? x : (parent[x] = find(parent[x]));
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) nums--;
            if (rank[pa] <= rank[pb]) parent[pa] = pb;
            else parent[pb] = pa;
            if (rank[pa] == rank[pb] && pa != pb) rank[pb]++;
        }

    }

}
