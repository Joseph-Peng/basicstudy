package lc051_100;

import java.util.*;

public class LC51_N皇后问题 {

    public List<List<String>> solveNQueens(int n) {
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        backtrace(0,queue,new boolean[n],new HashSet<>(), new HashSet<>(), n);
        return res;
    }

    List<List<String>> res = new LinkedList<>();

    // 从每一行开始放置
    // 参数：放到第几行row，每一行的皇后放置的列索引queue，列是否被放置cols
    //      正对角线放置的情况、反对角线放置的情况
    public void backtrace(int row, int[] queue, boolean[] cols, Set<Integer> dia1, Set<Integer> dia2, int n){
        // 出口
        if (row == n){
            List<String> solution = generateSolution(queue);
            res.add(solution);
            return;
        }

        // 状态转移：当前行的每一列都可以去尝试
        for(int i = 0; i < n; ++i){
            // 当前列已经被放置了一个皇后
            if (cols[i]) continue;
            // 判断正对角线
            int d1 = row - i;
            if (dia1.contains(d1)) continue;
            // 判断反对角线
            int d2 = row + i;
            if (dia2.contains(d2)) continue;

            //回溯
            queue[row] = i;
            cols[i] = true;
            dia1.add(d1);
            dia2.add(d2);

            backtrace(row+1, queue, cols, dia1, dia2, n);

            queue[row] = -1;
            cols[i] = false;
            dia1.remove(d1);
            dia2.remove(d2);

        }

    }

    private List<String> generateSolution(int[] queue) {
        List<String> solution = new ArrayList<>();
        int n = queue.length;
        for(int i = 0; i<n;++i){
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queue[i]] = 'Q';
            solution.add(new String(row));
        }
        return solution;
    }
}
