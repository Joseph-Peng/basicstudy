package lc701to800;

import java.util.LinkedList;
import java.util.Queue;

public class LC733_图像渲染 {

    public static void main(String[] args) {
        int[][] image = {{0,0,0},{0,1,1}};

        floodFill(image, 1,1,1);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] dirs = {{1, 0},{-1, 0}, {0, -1}, {0, 1}};
        int m = image.length;
        int n = image[0].length;

        boolean[][] visited = new boolean[m][n];

        int flag = image[sr][sc];
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int[] dir : dirs){
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                if(x >= 0 && y>=0 && x < m && y < n && image[x][y] == flag && !visited[x][y]){
                   // System.out.println(x +" " + y);
                    image[x][y] = newColor;
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return image;
    }

}
