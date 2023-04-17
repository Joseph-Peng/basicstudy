import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bos0 = sc.nextInt();
        int bos1 = sc.nextInt();
        int a[][] = new int[n][2];
        for(int i = 0; i < n; ++i){
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double r1 =  o1[0] * 1.0 / o2[1];
                double r2 =  o2[0] * 1.0 / o1[1];
                if (r1 < r2) return -1;
                else if (r1 > r2) return 1;
                else return 0;
            }
        });

        long pre = a[0][0];
        int res = 0;
        for(int i = 1; i < n; ++i){
            res = (int) Math.max(res, pre/a[i][1]);
            pre *= a[i][0];
        }

        System.out.println(res);
    }
}
