package lc000to050;

public class LC05_最长的回文子串 {

    // dp
    //dp[i][j] 表示 s[i..j] 是否是回文串
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for(int i = 0;i<len;++i){
            dp[i][i] = true;
        }

        // 从长度2开始
        for (int L = 2; L <= len; ++L) {
            for (int i = 0; i < len; ++i) {
                int j = i + L - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (s.charAt(i) == s.charAt(j)){
                    if (L < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    dp[i][j] = false;
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，
                // 此时记录回文长度和起始位置
                if (dp[i][j] && L>maxLen){
                    maxLen = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }


    // 中心扩散法
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); ++i) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + (len) / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
