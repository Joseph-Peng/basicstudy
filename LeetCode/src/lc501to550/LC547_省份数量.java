package lc501to550;

public class LC547_省份数量 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind set = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != j && isConnected[i][j] == 1){
                    set.union(i, j);
                }
            }
        }
        return set.nums;
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
