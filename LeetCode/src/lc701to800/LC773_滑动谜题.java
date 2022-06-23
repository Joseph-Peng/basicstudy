package lc701to800;

import java.util.*;

public class LC773_滑动谜题 {

    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sbf.append(board[i][j]);
            }
        }
        String initial = sbf.toString();
        if (initial.equals("123450")) return 0;
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(initial);
        Set<String> seen = new HashSet<String>();
        seen.add(initial);
        while (!queue.isEmpty()){
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for(String next : getNext(cur)){
                    if (!seen.contains(next)){
                        if(next.equals("123450")) return step;
                        queue.offer(next);
                        seen.add(next);
                    }
                }
            }

        }
        return -1;
    }

    private List<String> getNext(String cur) {
        List<String> res = new LinkedList<>();
        int x = cur.indexOf('0');
        char[] arr = cur.toCharArray();
        for(int y : neighbors[x]){
            swap(arr, x, y);
            res.add(new String(arr));
            swap(arr, x, y);
        }
        return res;
    }

    public void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
