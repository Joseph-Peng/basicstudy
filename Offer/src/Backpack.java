public class Backpack {

    /*
        8 4
        1 2 3
        2 3 4
        3 4 5
        4 5 6
     */

    public static void main(String[] args) {
        int n = 4, total = 8;
        int weight[] = {2,3,4,5};
        int value[] = {3,4,5,6};

        int dp[][] = new int[weight.length+1][total+1];

        for (int i = 1; i<=n; ++i){
            for(int j = 1; j<=8; j++){
                if (weight[i-1]<=j){  // 物品编号i可以被装入
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                }else {  // 不能被装入
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[weight.length][total]);
        find(dp,n,total,weight);
    }

    public static void find(int[][] dp, int i, int j, int[] weight){
        while (i>0){
            if (dp[i-1][j] == dp[i][j]){
                i = i-1;
            }else {
                System.out.println(i);
                j-=weight[i-1];
                i--;
            }
        }
    }
}
