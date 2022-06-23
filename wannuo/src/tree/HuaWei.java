package tree;

import java.util.LinkedList;
import java.util.Queue;

public class HuaWei {

    public static void main(String[] args) {
        char[][] grid = {
                {'N', 'N', 'W', 'B', 'W', 'B'},
                {'B', 'B', 'W', 'B', 'B', 'B'},
                {'W', 'W', 'W', 'B', 'B', 'B'},
                {'N', 'W', 'W', 'W', 'B', 'B'},
                {'W', 'N', 'N', 'W', 'B', 'N'}
        };
        solution(5, 6, grid);
    }

    public static void solution(int m, int n, char[][] grid) {
        int resB = 0;
        int resW = 0;
        int[][] visit = new int[m][n];
        int flag = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'B') {
                    resB += bfs(i, j, visit, flag, grid, 'B');
                    flag++;
                } else if (grid[i][j] == 'W') {
                    resW += bfs(i, j, visit, flag, grid, 'W');
                    flag++;
                }
            }
        }
        System.out.println("B " + resB + " W " + resW);
    }

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int bfs(int i, int j, int[][] visit, int flag, char[][] grid, char color) {
        int power = 0;
        int cnt = 1;
        grid[i][j] = 'S';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int newX = pos[0] + dir[0];
                int newY = pos[1] + dir[1];
                if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid.length) continue;
                if (grid[newX][newY] == 'N' && visit[newX][newY] != flag) {
                    power++;
                    visit[newX][newY] = flag;
                }
                if (grid[newX][newY] == color) {
                    queue.offer(new int[]{newX, newY});
                    cnt++;
                    grid[newX][newY] = 'S';
                }
            }
        }
        return power < 2 ? 0 : cnt;
    }
}
