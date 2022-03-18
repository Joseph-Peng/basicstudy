package nowcoder.dp;

public class 最长公共子序列 {

    public String LCS (String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        if (len1 == 0 || len2 == 0) return "-1";
        int[][] dp = new int[len1+1][len2+1];
        dp[0][0] = 0;
        for(int i = 1; i<=len1;++i){
            for (int j = 1;j<=len2;++j){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        if (dp[len1][len2] == 0) return "-1";
        // 找出最长公共子序列
        StringBuffer res = new StringBuffer();
        int str1Index = len1;
        int str2Index = len2;
        while (str1Index!=0 && str2Index!=0){
            if (str1.charAt(str1Index-1) == str2.charAt(str2Index-1)){
                res.append(str1.charAt(str1Index-1));
                str1Index--;
                str2Index--;
            }else {
                if (dp[str1Index-1][str2Index] > dp[str1Index][str2Index-1]){
                    str1Index--;
                }else {
                    str2Index--;
                }
            }
        }
        if (res.length() == 0){
            return "-1";
        }
        return res.reverse().toString();
    }

}
