package codetop;

import java.util.ArrayList;
import java.util.List;

public class 组合 {

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }

    public static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        backTrace(1,n,k,path);
        return res;
    }

    private static void backTrace(int start, int n, int k, List<Integer> path) {
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        //for(int i = start; i<=n;++i){
        for(int i = start; i<=n-(k-path.size())+1;++i){
            path.add(i);
            backTrace(i+1,n,k,path);
            path.remove(path.size()-1);
        }
    }

}
