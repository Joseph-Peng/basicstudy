package codetop;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Joseph Peng
 * @date 2022/8/20 17:55
 */
public class 数组的全部子集 {
    static List<Integer> path = new LinkedList<>();
    public static void getSub(int[] arr, int idx, int sum){
        if(idx >= arr.length) return;
        getSub(arr, idx+1, sum);
        sum = sum*10 + arr[idx];
        path.add(sum);
        getSub(arr, idx+1, sum);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        getSub(arr, 0, 0);
        Collections.sort(path);
        System.out.println(path);
    }
}
