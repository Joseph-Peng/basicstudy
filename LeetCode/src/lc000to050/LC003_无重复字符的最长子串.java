package lc000to050;

import java.util.HashMap;
import java.util.Map;

public class LC003_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = -1;
        int maxLen = 1;
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if(dict.containsKey(ch)){
                left = Math.max(left,dict.get(ch));
            }
            dict.put(ch,i);
            maxLen = Math.max(i-left,maxLen);
        }
        return maxLen;
    }
}
