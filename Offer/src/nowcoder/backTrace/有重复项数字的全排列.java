package nowcoder.backTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class 有重复项数字的全排列 {

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(num);
        backTrace(num, res, path, new boolean[num.length]);
        return res;
    }

    public void backTrace(int[] num, ArrayList<ArrayList<Integer>> res,
                          LinkedList<Integer> path, boolean[] visited ) {
        if (path.size() == num.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < num.length; ++i) {
            if(i>0 && num[i] == num[i-1] && visited[i-1] == false) continue;
            if(!visited[i]){
                visited[i] = true;
                path.addLast(num[i]);
                backTrace(num,res,path,visited);
                path.removeLast();
                visited[i] = false;
            }
        }
    }
}
