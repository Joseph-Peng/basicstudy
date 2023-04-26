package sort;

import java.util.Arrays;

/**
 * @author Joseph Peng
 * @date 2023/4/25 16:17
 */
public class 对两个数组同时排序的方法 {
    // 通用做法是创建一个下标数组，对下标数组排序，这样既不会打乱输入的数组，
    // 又保证了两个数组的对应关系。
    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            int n = names.length;
            Integer[] id = new Integer[n];
            for (int i = 0; i < n; ++i)
                id[i] = i;
            Arrays.sort(id, (i, j) -> heights[j] - heights[i]);
            String[] ans = new String[n];
            for (int i = 0; i < n; ++i)
                ans[i] = names[id[i]];
            return ans;
        }
    }
}
