package lc451to500;

public class LC459_重复的子字符串 {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length()==0) return false;
        int count = s.length()/2 + 1;
        for (int i = 1; i<=count; ++i){
            if (s.length()%i==0){
                String base = s.substring(0,i);
                for(int j = i; j+i<=s.length(); j+=i){
                    String check = s.substring(j,j+i);
                    if(!check.equals(base)) break;
                    if(j+i == s.length()) return true;
                }
            }
        }
        return false;
    }
}
