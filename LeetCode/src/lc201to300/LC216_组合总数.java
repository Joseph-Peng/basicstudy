package lc201to300;

import java.util.LinkedList;
import java.util.List;

public class LC216_组合总数 {

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        backtrace(1,0,new LinkedList<>(),k,n);
        return res;
    }

    static List<List<Integer>> res = new LinkedList<>();

    // 参数：idx,sum,path
    public static void backtrace1(int idx, int sum,List<Integer> path,int k, int n){
        // 出口
        if(idx>9 || path.size() == k || sum >= n){
            if (path.size() == k && sum == n) res.add(new LinkedList<>(path));
            return;
        }

        // 不选
        backtrace1(idx+1, sum, path, k, n);
        // 选
        //if (sum + idx > k) return;
        path.add(idx);
        backtrace1(idx+1, sum+idx, path, k, n);
        path.remove(path.size()-1);
    }

    // 参数：idx,sum,path
    public static void backtrace(int idx, int sum,List<Integer> path,int k, int n){
        // 出口
        if(idx>9 || path.size() == k || sum >= n){
            if (path.size() == k && sum == n) res.add(new LinkedList<>(path));
            return;
        }

        for(int i = idx; i<=9; ++i){
            if (sum + i > n) return;
            path.add(i);
            backtrace(i+1, sum+i, path, k, n);
            path.remove(path.size()-1);
        }
    }
}
