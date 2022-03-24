package nowcoder.backTrace;

import java.util.ArrayList;
import java.util.LinkedList;

public class 没有重复数字的全排列 {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // 存一种排列
        LinkedList<Integer> list = new LinkedList<>();
        backTrace(num,list);
        return res;
    }
    public void backTrace(int[] num, LinkedList<Integer> list){
        if(list.size() == num.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < num.length;++i){
            if(list.contains(num[i])) continue;
            list.addLast(num[i]);
            backTrace(num,list);
            list.removeLast();
        }
    }

    public void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
