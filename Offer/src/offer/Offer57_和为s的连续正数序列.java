package offer;

import java.util.ArrayList;
import java.util.List;

public class Offer57_和为s的连续正数序列 {

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<int[]>();
        int begin = 1, end = 2, sum = 3;
        while (begin<end) {
            if(sum == target){
                int[] arr = new int[end-begin+1];
                for(int k = begin;k<=end;k++){
                    arr[k-begin] = k;
                }
                res.add(arr);
            }
            if(sum>=target){
                sum-=begin;
                begin++;
            }else {
                end++;
                sum+=end;
            }
        }

        return res.toArray(new int[0][]);

    }
}
