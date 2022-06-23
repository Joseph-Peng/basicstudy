package lc401to450;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC417_太平洋大西洋 {

    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i = 0; i < m; ++i){
            bfs(i, 0, heights, pacific);
            bfs(i, n-1, heights, atlantic);
        }
        for(int j = 0; j < n; ++j){
            bfs(0, j, heights, pacific);
            bfs(m-1, j, heights, atlantic);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void bfs(int x, int y, int[][] heights, boolean[][] canReach){
        if(canReach[x][y]) return;
        canReach[x][y] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int[] dir : dirs){
                int newX = pos[0] + dir[0];
                int newY = pos[1] + dir[1];
                if(newX >= 0 && newY >= 0 && newX < heights.length && newY < heights[0].length && heights[newX][newY] >= heights[pos[0]][pos[1]] && !canReach[newX][newY]){
                    queue.offer(new int[]{newX, newY});
                    canReach[newX][newY] = true;
                }
            }
        }
    }
}
