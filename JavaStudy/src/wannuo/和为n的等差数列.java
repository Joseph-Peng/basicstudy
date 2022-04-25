package wannuo;

import java.util.ArrayList;
import java.util.List;

public class 和为n的等差数列 {

    public static void main(String[] args) {
        System.out.println(findSubArr(10));
    }

    public static List<List<Integer>> findSubArr(int n){
        List<List<Integer>> res = new ArrayList<>();
        int left = 1, right = 1, sum = 0;
        while (right < n){
            if(sum == n){
                List<Integer> temp = new ArrayList<>();
                for(int i = left; i<right;++i){
                    temp.add(i);
                }
                res.add(temp);
                sum -= left;
                left++;
            }else if(sum < n){
                sum += right;
                right++;
            }else{
                sum -= left;
                left++;
            }
        }
        return res;
    }

    public static List<int[]> findSubArr1(int n){
        List<int[]> res = new ArrayList<>();
        int left = 1, right = 1, sum = 0;
        while (right < n){
            if(sum == n){
                int[] temp = new int[right-left];
                for(int i = left; i<right;++i){
                    temp[i-left] = i;
                }
                res.add(temp);
                sum -= left;
                left++;
            }else if(sum < n){
                sum += right;
                right++;
            }else{
                sum -= left;
                left++;
            }
        }
        return res;
    }
}
