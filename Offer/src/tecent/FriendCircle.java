package tecent;

import java.util.Scanner;

public class FriendCircle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0; t<T; ++t){
            int n = in.nextInt();
            UnionFind unionFind = new UnionFind();
            for(int i = 0; i < n; ++i){
                int u1 = in.nextInt();
                int u2 = in.nextInt();
                unionFind.union(u1,u2);
            }
            int max = 0;
            for(int i = 0; i<unionFind.personNums.length; ++i){
                max = Math.max(unionFind.personNums[i],max);
            }
            System.out.println(max);
        }
    }

    private static class UnionFind {
        public static int[] parent = new int[10000001];
        public static int[] personNums = new int[10000001];

        public UnionFind(){
            for(int i = 1; i <= 10000000; i++){
                parent[i] = i;
                personNums[i] = 1;
            }
        }

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
            personNums[rootY] += personNums[rootX];
        }
    }
}
