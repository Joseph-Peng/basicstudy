package lc1000to2000;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Joseph Peng
 * @date 2023/5/8 9:49
 */
public class LC1263_推箱子 {

    public static void main(String[] args) {
        char[][] grid = {{'#', '#', '#', '#', '#', '#'},
                {'#', 'T', '.', '.', '#', '#'},
                {'#', '.', '#', 'B', '.', '#'},
                {'#', '.', '.', '.', '.', '#'},
                {'#', '.', '.', '.', 'S', '#'},
                {'#', '#', '#', '#', '#', '#'}};

        LC1263_推箱子 test = new LC1263_推箱子();
        System.out.println(test.minPushBox(grid));
    }

    /**
     * grid = [["#","#","#","#","#","#"],
     * ["#","T","#","#","#","#"],
     * ["#",".",".","B",".","#"],
     * ["#",".","#","#",".","#"],
     * ["#",".",".",".","S","#"],
     * ["#","#","#","#","#","#"]]
     */

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 【BFS+DFS】
     * 以箱子的视角进行BFS
     * 以人的视角进行DFS
     * 后者作为前者得以进行的前提
     */
    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 1. 找到人的起始位置、箱子的起始位置
        int px = -1, py = -1, bx = -1, by = -1;
        int tx = -1, ty = -1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
                if (grid[i][j] == 'T') {
                    tx = i;
                    ty = j;
                    grid[i][j] = '.';
                }
                if (grid[i][j] == 'S') {
                    px = i;
                    py = j;
                    grid[i][j] = '.';
                }
            }
        }

        // 2. 初始化BFS的队列,以箱子的视角进行BFS
        Queue<Box> queue = new LinkedList();
        // 记录每一个坐标的四点方向访问情况
        boolean[][][] visited = new boolean[m][n][4];
        for (int i = 0; i < 4; i++) {
            int[] direction = directions[i];
            // 记录箱子能够被人推倒起点的方向，初始化箱子在起点的方向选择。
            if (personCanReach(grid, m, n, px, py, bx - direction[0], by - direction[1], new boolean[m][n])) {
                queue.add(new Box(bx, by, i));
                visited[bx][by][i] = true;
            }
        }

        // 3. 开始进行BFS
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                // 标准的bfs写法
                // 1. 出队
                Box box = queue.poll();
                if (box.x == tx && box.y == ty) return step;
                grid[box.x][box.y] = 'B';
                px = box.x - directions[box.direction][0];
                py = box.y - directions[box.direction][1];

                // 2. 判断是否能够将箱子朝某一方向移动，例如要向左移动，人就要能够到达箱子当前位置的左边
                for (int i = 0; i < 4; i++) {
                    int[] direction = directions[i];
                    int nextX = box.x + direction[0];
                    int nextY = box.y + direction[1];
                    // 箱子的下个位置是否合法？箱子的下一个状态是不是重复了？ 人是否能绕到箱子的后面？
                    if (!isValid(grid, m, n, nextX, nextY) ||
                            visited[nextX][nextY][i] ||
                            !personCanReach(grid, m, n, px, py, box.x - direction[0], box.y - direction[1], new boolean[m][n])) {
                        continue;
                    }
                    queue.add(new Box(nextX, nextY, i));
                    visited[nextX][nextY][i] = true;
                }
                grid[box.x][box.y] = '.';
            }
            step++;
        }
        return -1;
    }

    // 人是否可以某一位置(startX, startY)到达另一位置(targetX, targetY)
    private boolean personCanReach(char[][] grid, int m, int n, int startX, int startY, int targetX, int targetY, boolean[][] visited) {
        if (startX == targetX && startY == targetY) {
            return true;
        }
        visited[startX][startY] = true;
        for (int[] direction : directions) {
            int nextX = startX + direction[0];
            int nextY = startY + direction[1];
            if (isValid(grid, m, n, nextX, nextY) && !visited[nextX][nextY]) {
                if (personCanReach(grid, m, n, nextX, nextY, targetX, targetY, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 某位置是否可以踏足
    private boolean isValid(char[][] grid, int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '.';
    }

    class Box {
        int x;
        int y;
        int direction;

        public Box(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "x=" + x +
                    ", y=" + y +
                    ", direction=" + direction +
                    '}';
        }
    }
}
