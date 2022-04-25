package backtrace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 牛牛走台阶 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ls = br.readLine().split(" ");
        int n = Integer.parseInt(ls[0]);
        int m = Integer.parseInt(ls[1]);
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                Arrays.fill(memory[i][j], -1);
            }
        }
        System.out.println(dfs1(0, 0, 0, m, n));
        //dfs(0,0,0,m,n);
        //System.out.println(cnt);
    }

    static int cnt = 0;

    // 参数： 已走步数（sum）、前一步走的步数（lt）、前前一步（bflt）
    public static void dfs(int sum, int lt, int bflt, int m, int n) {
        if (sum >= n) {
            if (sum == n) cnt++;
            return;
        }
        for (int i = 1; i <= m; ++i) {
            if (i != lt && i != bflt) {
                dfs(sum + i, i, lt, m, n);
            }
        }
    }

    static int[][][] memory = new int[100010][8][8];

    // 参数： 已走步数（sum）、前一步走的步数（lt）、前前一步（bflt）
    public static int dfs1(int sum, int lt, int bflt, int m, int n) {
        if (sum >= n) {
            if (sum == n) return 1;
            return 0;
        }
        int ans = 0;
        if (memory[sum][lt][bflt] != -1) return memory[sum][lt][bflt];
        for (int i = 1; i <= m; ++i) {
            if (i != lt && i != bflt) {
                ans += dfs1(sum + i, i, lt, m, n);
                ans = ans%1000000007;
            }
        }
        memory[sum][lt][bflt] = ans;
        return ans;
    }
}
