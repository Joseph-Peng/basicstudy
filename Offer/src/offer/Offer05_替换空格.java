package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Offer05_替换空格 {

    public String replaceSpace(String s) {
        if (null == s || s.length() ==0) return null;
        int numberOfSpace = 0;
        int oldLen = s.length();
        for(int i = 0; i < oldLen; ++i){
            if(s.charAt(i) == ' ') ++numberOfSpace;
        }
        StringBuffer res = new StringBuffer(s);
        int newLen = oldLen + 2*numberOfSpace;
        res.setLength(newLen);
        int oldIndex = oldLen -1;
        int newIndex = newLen -1;
        while (oldIndex<newIndex){
            if (res.charAt(oldIndex) == ' '){
                res.setCharAt(newIndex--,'0');
                res.setCharAt(newIndex--,'2');
                res.setCharAt(newIndex--,'%');
            }else {
                res.setCharAt(newIndex--,res.charAt(oldIndex));
            }
            --oldIndex;
        }
        return res.toString();
    }

    public String replaceSpace1(String s) {
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            bf.append(s.charAt(i) == ' '? "%20":s.charAt(i));
        }
        return bf.toString();
    }

    public String replaceSpace2(String s) {
        return s.replace(" ", "%20");
    }
}
