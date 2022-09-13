package lc801to900;

import java.util.*;

/**
 * @author Joseph Peng
 * @date 2022/9/6 8:47
 */
public class LC828_统计子串中的唯一字符 {

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("LEETCODE"));
    }

    public static int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<>();
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if (!index.containsKey(c)){
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }

        int res = 0;
        for(Map.Entry<Character, List<Integer>> entry : index.entrySet()){
            List<Integer> list = entry.getValue();
            list.add(s.length());
            for(int i = 1; i < list.size()-1; ++i){
                int count = (list.get(i) - list.get(i-1)) * (list.get(i+1) - list.get(i));
                res += count;
            }
        }
        return res;
    }
}
