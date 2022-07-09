package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijistl {

    public int dijistl(int[][] G, int start, int end, int n){
        int[] dis = new int[n+1];
        Arrays.fill(dis, 10000010);
        dis[start] = 0;
        dis[0] = 0;
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        priorityQueue.add(new int[]{0, start});
        while (!priorityQueue.isEmpty()){
            int[] arr = priorityQueue.poll();
            int node = arr[1], dist = arr[0];
            if(visited[node]) continue;
            visited[node] = true;
            for(int i = 1; i <= n; ++i){
                if(G[node][i] < 100010 && dis[i] > dist + G[node][i]){
                    dis[i] = dist + G[node][i];
                    priorityQueue.add(new int[]{dis[i], i});
                }
            }
        }
        return dis[end];
    }
}
