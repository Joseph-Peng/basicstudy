import java.util.LinkedList;
import java.util.Queue;

public class LC1162_地图分析 {

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        boolean hasOcean = false;
        int[] pos = null;
        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        while (!queue.isEmpty()){
            pos = queue.poll();
            for(int[] dir : dirs){
                int newX = pos[0] + dir[0];
                int newY = pos[1] + dir[1];
                if(newX < 0 || newY < 0 || newX >= m || newY >= n || grid[newX][newY] != 0){
                    continue;
                }
                grid[newX][newY] = grid[pos[0]][pos[1]] + 1;
                queue.offer(new int[]{newX, newY});
                hasOcean = true;
            }
        }

        if (!hasOcean) return -1;

        return grid[pos[0]][pos[1]] - 1;

    }



}
