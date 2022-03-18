package nowcoder.dp;

public class 最长公共子串 {

    public String LCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int maxLen = 0;//记录最长公共子串的长度
        //记录最长公共子串最后一个元素在字符串str1中的位置
        int lastIndex = 0;
        int[][] dp = new int[len1 + 1][len2+ 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                //递推公式，两个字符相等的情况
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    //如果遇到了更长的子串，要更新，记录最长子串的长度，
                    //以及最长子串最后一个元素的位置
                    if (dp[i + 1][j + 1] > maxLen) {
                        maxLen = dp[i + 1][j+1];
                        lastIndex = i;
                    }
                } else {
                    //递推公式，两个字符不相等的情况
                    dp[i + 1][j+1] = 0;
                }
            }
        }
        //最字符串进行截取，substring(a,b)中a和b分别表示截取的开始和结束位置
        return str1.substring(lastIndex - maxLen + 1, lastIndex + 1);
    }
}
