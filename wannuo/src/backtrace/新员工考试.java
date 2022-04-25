package backtrace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 新员工考试 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8, 8, 8, 8, 8};
        backtrace(0, 0, 0, scores, N);
        for (int i = 0; i<110; i++){
            for(int j = 0; j<4; j++){
                Arrays.fill(memory[i][j], -1);
            }
        }
        System.out.println(res);
        System.out.println(backtrace1(0, 0, 0, scores, N));
    }

    public static int res = 0;

    // 参数：分数（score）、错题数（cnt）、当前题号（idx）
    public static void backtrace(int score, int cnt, int idx, int[] scores, int N) {
        // 出口
        if (cnt == 3 || score == N || idx >= 25) {
            if (score == N) res++;
            return;
        }
        // 做对
        backtrace(score + scores[idx], cnt, idx + 1, scores, N);
        // 做错
        backtrace(score, cnt + 1, idx + 1, scores, N);
    }

    static int[][][] memory = new int[110][4][26];

    public static int backtrace1(int score, int cnt, int idx, int[] scores, int N) {
        // 出口
        if (cnt == 3 || score == N || idx >= 25) {
            if (score == N) return 1;
            return 0;
        }
        if (memory[score][cnt][idx] != -1) return memory[score][cnt][idx];

        int ans = 0;
        ans = backtrace1(score + scores[idx], cnt, idx + 1, scores, N) +
                backtrace1(score, cnt + 1, idx + 1, scores, N);
        memory[score][cnt][idx] = ans;
        return ans;
    }
}
