package example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 区间内01数量相同 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int maxLen = 0;
        int n = input.length();
        int[][] dp = new int[n+1][2]; // 记录当前数组位置的0和1的个数
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 1;i<= n;++i){
            if (input.charAt(i-1) == '0'){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1];
            }else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1] + 1;
            }
        }
        for(int L = n-1; L>=0;--L){  // 从长度最长开始遍历
            Map<String,String> map = new HashMap<>(); // key是0和1个数的差组成的一个字符串
            for(int i = 0;i <= n-L;++i){
                int j = i+L;
                if (j<=n){
                    String s = (dp[j][0]-dp[i][0]) +"";
                    s += dp[j][1]-dp[i][1];
                    //System.out.println(s);
                    if (map.containsKey(s)){
                        System.out.print(map.get(s)+ " ");
                        System.out.println((i+1)+" "+(j));
                        return;
                    }else{
                        map.put(s,(i+1)+" "+(j));
                    }
                }

            }
        }
    }
}
