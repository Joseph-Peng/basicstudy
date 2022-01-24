package offer;

import java.util.HashMap;
import java.util.Map;

public class Offer48_最长不含重复字符的子字符串 {

    public static void main(String[] args) {
        System.out.println(new Offer48_最长不含重复字符的子字符串().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Offer48_最长不含重复字符的子字符串().lengthOfLongestSubstring2("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(null == s || s.length() == 0) return 0;
        Map<Character,Integer> dict = new HashMap<>();
        int left = -1, maxLen = 0;
        for(int i = 0; i< s.length(); ++i){
            char ch = s.charAt(i);
            if(dict.containsKey(ch)){
                left = Math.max(dict.get(ch),left);
            }
            dict.put(s.charAt(i),i);
            maxLen = Math.max(maxLen,i-left);
        }
        return maxLen;
    }

    /**
     * 动态规划
     * 假设dp[j-1] = a   char(j)在map中出现的位置为i
     *             dp[j-1]+1       j-i>a
     * dp[j] =
     *             j-i            dp[j−1]≥j−i
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if(null == s || s.length() == 0) return 0;
        Map<Character,Integer> dict = new HashMap<>();
        int p = 0, maxLen = 0;
        for(int j = 0; j< s.length(); ++j){
            char ch = s.charAt(j);
            int i = dict.getOrDefault(ch,-1);
            p = p < j-i? p+1 : j-i;
            dict.put(s.charAt(j),j);
            maxLen = Math.max(maxLen,p);
        }
        return maxLen;
    }

}
