import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        int[] pre = new int[n+1];
        pre[0] = 0;
        for (int i = 0;i<n;++i){
            pre[i+1] = a[i] == -1? pre[i]+1:pre[i];
        }

        int sum = 0;
        for (int i = 0; i< a.length;++i){
            for(int j = i;j<a.length;++j){
                int t2 = pre[j+1] - pre[i];
                if (t2%2==0) sum++;
            }
        }
        System.out.println(sum);
    }
}
