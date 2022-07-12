package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC743_网络延迟时间 {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] G = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) Arrays.fill(G[i], 100010);
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            G[u][v] = w;
        }
        int[] dis = dijistl(G, k, n);
        int ans = 0;
        for (int i = 1 ; i <= n ; i++) {
            if (dis[i] == 100010) return -1;
            ans = Math.max(ans, dis[i]);
        }
        return ans;
    }

    public int[] dijistl(int[][] G, int start, int n) {
        int[] dis = new int[n + 1];
        Arrays.fill(dis, 100010);
        dis[start] = 0;
        dis[0] = 0;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        priorityQueue.add(new int[]{0, start});
        while (!priorityQueue.isEmpty()) {
            int[] arr = priorityQueue.poll();
            int node = arr[1], dist = arr[0];
            if (visited[node]) continue;
            visited[node] = true;
            for (int i = 1; i <= n; ++i) {
                if (G[node][i] < 100010 && dis[i] > dist + G[node][i]) {
                    dis[i] = dist + G[node][i];
                    priorityQueue.add(new int[]{dis[i], i});
                }
            }
        }
        return dis;
    }

}
