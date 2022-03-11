package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Offer38_字符串的排列 {



    public String[] permutation(String s) {
        List<String> res = new ArrayList<String>();
        dfs(0,s.toCharArray(),res);
        return res.toArray(new String[0]);
    }

    private void dfs(int x, char[] c, List<String> res) {
        if (x == c.length){
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i<c.length; ++i){
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(c,i,x);
            dfs(x+1,c,res);
            swap(c,i,x);
        }
    }

    public void swap(char s[], int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


    public String[] permutation1(String s) {
        List<String> res = new ArrayList<>();
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        dfs(arr,new StringBuffer(),res,new boolean[s.length()]);
        return res.toArray(new String[0]);
    }

    private void dfs(char[] str, StringBuffer sbf, List<String> res, boolean[] visited) {
        if (sbf.length() == str.length){
            res.add(sbf.toString());
            return;
        }

        for(int i = 0;i<str.length;++i){
            // 剪枝从树层上剪枝
            // 如果visited[i-1]==false 说明是在当前循环中，前面一个与自己相同的数已经用过了
            // 这时候剪枝避免进入下一层决策树
            if (i>0 && str[i-1] == str[i] && visited[i-1]==false) continue;
            if (!visited[i]){
                sbf.append(str[i]);
                visited[i] = true;
                dfs(str,sbf,res,visited);
                visited[i] = false;
                sbf.deleteCharAt(sbf.length()-1);
            }
        }
    }
}
