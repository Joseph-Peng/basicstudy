package lc000to050;

import java.util.ArrayList;
import java.util.List;

public class LC37_解数独 {

    // 每一行1-9放置情况
    private boolean[][] row = new boolean[9][9];
    // 每一列1-9放置情况
    private boolean[][] column = new boolean[9][9];
    // 每一块1-9放置情况
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    row[i][digit] = true;
                    column[j][digit] = true;
                    block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(0, board);
    }

    // 一个空格一个空格的填
    // 参数：填到哪个空格了
    public void dfs(int idx, char[][] board) {
        if (idx == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(idx);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!row[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                row[i][digit] = true;
                column[j][digit] = true;
                block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(idx + 1, board);
                row[i][digit] = false;
                column[j][digit] = false;
                block[i / 3][j / 3][digit] = false;
            }
        }
    }

}
