import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 面试题水域大小 {

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < land.length; ++i){
            for(int j = 0; j < land[0].length; ++j){
                if(land[i][j] == 0) list.add(bfs(i, j, land));
            }
        }
        list.sort((a, b) -> a-b);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size() ;++i){
            res[i] = list.get(i);
        }
        return res;
    }

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0},{1,1},{1,-1},{-1,1},{-1,-1}};

    public static int bfs(int x, int y, int[][] land){
        land[x][y] = 1;
        int num = 1;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int[] dir : dirs){
                int newX = pos[0] + dir[0];
                int newY = pos[1] + dir[1];
                if(newX >= 0 && newY >= 0 && newX < land.length && newY < land[0].length && land[newX][newY] == 0){
                    queue.offer(new int[]{newX, newY});
                    land[newX][newY] = 1;
                    num++;
                }
            }
        }
        return num;
    }
}
