package lc000to050;

public class LC28_实现str {

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int next[] = getNext(needle);
        int i = 0, j = 0;
        while(i<haystack.length() && j < needle.length()){
            if(j==-1 || haystack.charAt(i) == needle.charAt(j)){
                ++i;
                ++j;
            }else{
                j = next[j];
            }
        }
        return j==needle.length()?i-j:-1;

    }

    public int[] getNext(String pattern){
        int[] next = new int[pattern.length()];
        int j = 0, k = -1;
        next[0] = -1;
        while(j < pattern.length()-1){
            if(k==-1 || pattern.charAt(j) == pattern.charAt(k)){
                next[++j] = ++k;
            }else{
                k = next[k];
            }
        }
        return next;
    }
}
