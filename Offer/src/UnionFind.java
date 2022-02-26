public class UnionFind {

    public static int[] parent = new int[10000001];
    public static int[] personNums = new int[10000001];

    public UnionFind(){
        for(int i = 1; i <= 10000000; i++){
            parent[i] = i;
            personNums[i] = 1;
        }
    }

    /**
     * 路径分裂 (Path Spliting)
     * 在find过程, 使路径上的每个节点都指向其祖父节点
     */
    public int find(int x){
        while (x!=parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;
        parent[rootX] = rootY;
        personNums[rootX] += personNums[rootY];
    }

}
