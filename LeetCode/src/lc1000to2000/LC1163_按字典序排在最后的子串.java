package lc1000to2000;

/**
 * @author Joseph Peng
 * @date 2023/4/24 9:30
 */
public class LC1163_按字典序排在最后的子串 {

    // 双指针解法
    public String lastSubstring(String s) {
        int length = s.length();
        int left = 0, right = 1, step = 0;
        while (right + step < length) {
            char lc = s.charAt(left+step);
            char rc = s.charAt(right+step);
            if (lc == rc){
                step++;
            }else{
                if (lc < rc){
                    left += step + 1;
                }else {
                    right += step + 1;
                }
                step = 0;
                right = Math.max(right, left + 1);
            }
        }
        return s.substring(left);
    }
    // llltcode
    /*
       l l    step = 0
       ll lt  step = 1
       left = left + step + 1  -> l
       right = left + 1       -> t
     */

    // 这种方法在s中的相同字符特别多时，会达到O(n^2)的复杂度
    public String lastSubstring1(String s) {
        if(s.length() == 0) return "";
        String res = s;
        char maxChar = s.charAt(0);
        for(int i = 1; i < s.length(); ++i){
            if(s.charAt(i) >= maxChar){
                maxChar = s.charAt(i);
                String t = s.substring(i);
                res = t.compareTo(res) > 0 ? t : res;
            }
        }
        return res;
    }
}
