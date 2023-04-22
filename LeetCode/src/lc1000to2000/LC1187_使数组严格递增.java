package lc1000to2000;

import java.util.*;

/**
 * @author Joseph Peng
 * @date 2023/4/20 9:57
 */
public class LC1187_使数组严格递增 {

    public static void main(String[] args) {
        LC1187_使数组严格递增 obj = new LC1187_使数组严格递增();
        int[] arr1 = {1, 5, 3, 6, 7};
        int[] arr2 = {1, 3, 2, 4};
        int[] arr3 = {4, 3, 2};
        int[] arr4 = {1, 6, 3, 3};

        System.out.println(obj.makeArrayIncreasing(arr1.clone(), arr2));
        System.out.println(obj.makeArrayIncreasing(arr1.clone(), arr3));
        System.out.println(obj.makeArrayIncreasing(arr1.clone(), arr4));
    }

    /**
     * 选或不选的思路
     * 从arr1的尾部向前开始计算，假设当前需要处理的位置为i，pre表示arr1[i+1]，第一个pre用MAX_VALUE来代替
     * 对于arr1[i]可以选择替换或者不替换
     * 不替换：需要arr1[i] < pre
     * 替换：需要将arr1[i]替换为arr2中小于pre的最大值
     */

    private int[] arr1;
    private int[] arr2;
    private Map<Integer, Integer> memo[];

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        Arrays.sort(arr2);
        int n = arr1.length;
        memo = new HashMap[n];
        Arrays.setAll(memo, e -> new HashMap<>());

        int res = dfs(n - 1, Integer.MAX_VALUE);
        return res < Integer.MAX_VALUE/2 ? res : -1;
    }

    public int dfs(int idx, int pre){
        if (idx < 0) return 0;
        if (memo[idx].containsKey(pre)) return memo[idx].get(pre);
        // 不选, 不选的条件为arr1[idx] < pre；如果不满足，说明必须要选，所以这里返回MAX_VALUE；除以2是为了防止溢出
        int res = arr1[idx] < pre ? dfs(idx - 1, arr1[idx]) : Integer.MAX_VALUE/2;
        // 选，找到arr2中小于pre的最大值,这里可以使用二分提高效率
        int idx2 = lowerBound(arr2, pre);
        if(idx2 >= 0) res = Math.min(res, dfs(idx - 1, arr2[idx2]) + 1);
        memo[idx].put(pre, res);
        return res;
    }

    private int lowerBound(int[] arr, int pre) {
        int i = 0, j = arr.length - 1;
        while (i <= j){
            int mid = (i + j) / 2;
            if (arr[mid] >= pre){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return j;
    }


}
