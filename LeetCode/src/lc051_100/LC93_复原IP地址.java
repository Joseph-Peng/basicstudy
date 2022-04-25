package lc051_100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC93_复原IP地址 {

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        backtrace(0,0,new LinkedList<>(),s);
        return res;
    }

    List<String> res = new LinkedList<>();
    // 参数：切割起始位置，切割次数，保存切割段的集合
    public void backtrace(int idx, int split, LinkedList<String> path, String s){
        // 出口
        if (idx >= s.length() || split == 4){
            if (idx == s.length() && split == 4){
                res.add(String.join(".",path));
            }
            return;
        }
        //如果剩余元素大于ip最多能容纳的个数，就剪枝。
        if (s.length() - idx > (4 - split) * 3) {
            return;
        }
        // 状态转移：每次可以分为切割长度为1,2,3的情况
        for(int i = idx; i<idx+3;++i){
            if (i >= s.length()) return;

            // 判断截取字符串是否合法
            if(isValid(s,idx,i)){
                String ipSegment = s.substring(idx, i+1);
                path.add(ipSegment);
                backtrace(i+1, split+1,path,s);
                path.removeLast();
            }
        }
    }

    private boolean isValid(String s, int begin, int end) {
        int len = end - begin + 1;
        if (len>1 && s.charAt(begin) == '0') return false;
        int num = Integer.parseInt(s.substring(begin,end + 1));
        return num <= 255;
    }
}
