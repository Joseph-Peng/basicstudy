package backtrace.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Joseph Peng
 * @date 2023/5/10 10:02
 */
public class 新员工考试 {

    /**
     * 100  1
     * 60   46
     * 90   50
     * 88   95
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] scores = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8, 8, 8, 8, 8};
        int N = Integer.parseInt(br.readLine());
        // 回溯做法
        backtrace(0, 0, 0, scores, N);
        System.out.println(res);

        // 记搜做法
        for (int i = 0; i<101; i++){
            for(int j = 0; j<4; j++){
                Arrays.fill(mem[i][j], -1);
            }
        }
        System.out.println(memoSearch(0,0,0,scores, N));

        br.close();
    }

    // 记搜
    static int[][][] mem = new int[101][4][26];
    public static int memoSearch(int sum, int cnt, int idx, int[] scores, int N){
        // 出口
        if (sum >= N || idx >= 25 || cnt == 3) {
            if (sum == N) return 1;
            return 0;
        }
        if (mem[sum][cnt][idx] != -1) return mem[sum][cnt][idx];

        int ans = 0;
        ans += memoSearch(sum + scores[idx], cnt, idx + 1, scores, N) +
                memoSearch(sum, cnt + 1, idx + 1, scores, N);

        mem[sum][cnt][idx] = ans;
        return ans;
    }

    static int res = 0;

    // 回溯：参数：分数，错题数，idx
    public static void backtrace(int sum, int cnt, int idx, int[] scores, int N) {
        // 出口
        if (sum >= N || idx >= 25 || cnt == 3) {
            if (sum == N) res++;
            return;
        }
        // 状态变化
        // 做对
        backtrace(sum + scores[idx], cnt, idx + 1, scores, N);
        // 做错
        backtrace(sum, cnt + 1, idx + 1, scores, N);
    }
}
