package tecent;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 区间问题 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int L = in.nextInt();
        int[][] temp = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                temp[i][j] = in.nextInt();
            }
        }
        //。获得了数组，进行排序
        Arrays.sort(temp, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int index = 0;
        int count = 0;
        int pre = 0;   //右边界
        while (pre < L) {
            if (temp[index][0] > pre) {
                System.out.println(-1);
            }
            int max = 0;
            while (index < n && temp[index][0] <= pre) {
                max = Math.max(max, temp[index][1]);
                index++;
            }
            count++;
            pre = max;
            if (pre >= L) {
                System.out.println(count);
                return;
            }
            if (index >= n) {
                System.out.println(-1);
                return;
            }
        }
    }
}
