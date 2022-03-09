package offer;

import java.util.ArrayList;
import java.util.List;

public class Offer38_字符串的排列 {



    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        char[] per = new char[s.length()];
        char[] str = s.toCharArray();
        dfs(str,per,0,res);
        return res.toArray(new String[0]);
    }

    private void dfs(char[] str, char[] per, int x, List<String> res) {
        if (x == str.length){
            res.add(new String(per));
            return;
        }

        for(int i = 0;i<str.length;++i){
            per[x] = str[i];
            dfs(str,per,x+1,res);
        }
    }
}
