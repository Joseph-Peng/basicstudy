package lc1000to2000;

import java.util.*;

/**
 * @author Joseph Peng
 * @date 2022/9/19 10:29
 */
public class LC1636_按照频率将数组升序排序 {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            list.add(num);
        }

        Collections.sort(list, (a, b) ->{
            int cnt1 = map.get(a), cnt2 = map.get(b);
            return cnt1 == cnt2 ? b - a : cnt1 - cnt2;
        });

        for(int i = 0; i < nums.length; ++i){
            nums[i] = list.get(i);
        }
        return nums;
    }
}
