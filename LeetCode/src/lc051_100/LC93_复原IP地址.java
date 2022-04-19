package lc051_100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC93_复原IP地址 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        Deque<String> path = new LinkedList<>();
        dfs(s, s.length(), 0, 4, path, res);
        return res;
    }

    private void dfs(String s, int len, int begin, int split, Deque<String> path, List<String> res) {
        //如果字符串已经遍历到最后了，并且已经切分为4段了，
        //就把当前路径上的元素加入到返回的结果集中
        if (begin == len) {
            if (split == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        // 选择列表，每次截取的长度可以为1,2,3
        for (int i = begin; i < begin + 3; ++i) {
            //如果超出字符串的长度，就直接退出
            if (i >= len) break;
            //如果剩余元素大于ip最多能容纳的个数，就剪枝。
            if (len - i > split * 3) {
                continue;
            }
            // 判断当前截取字符是否是小于0或者大于255
            if (checkSegment(s, begin, i)) {
                String segment = s.substring(begin, i + 1);
                path.add(segment);
                dfs(s, len, i + 1, split - 1, path, res);
                path.removeLast();
            }
        }

    }

    private boolean checkSegment(String s, int begin, int end) {
        int len = end - begin + 1;
        if (len > 1 && s.charAt(begin) == '0'){
            return false;
        }
        int res = len<=0 ? 0 : Integer.parseInt(s.substring(begin,end+1));
        return res>=0 && res<=255;
    }
}
