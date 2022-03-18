package nowcoder.string;

public class 最长公共前缀 {

    public String longestCommonPrefix (String[] strs) {
        if (strs.length == 0) return "";
        String res = strs[0];
        for(String str : strs){
            int i = 0;
            for (; i<res.length() && i<str.length();++i){
                if (str.charAt(i)!=res.charAt(i)) break;
            }
            res = res.substring(0,i);
        }
        return res;
    }
}
