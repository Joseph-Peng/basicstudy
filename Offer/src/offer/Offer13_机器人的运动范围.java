package offer;

public class Offer13_机器人的运动范围 {

    public int movingCount(int m, int n, int k) {
        if (k == 0) return 1;
        boolean[][] visited = new boolean[m][n];

        return dfs(m, n, 0, 0, k, visited);

    }

    private int dfs(int m, int n, int i, int j, int k, boolean[][] visited) {
        if (i >= m || j >= n || visited[i][j] || countNum(i, j) > k) return 0;
        visited[i][j] = true;
        return 1 + dfs(m, n, i + 1, j, k, visited) + dfs(m, n, i, j + 1, k, visited);
    }

    public int countNum(int m, int n) {
        int sum = 0;
        while (m > 0) {
            sum += m % 10;
            m /= 10;
        }
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
