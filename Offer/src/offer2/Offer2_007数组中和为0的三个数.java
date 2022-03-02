package offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer2_007数组中和为0的三个数 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        Arrays.sort(nums);

        for(int first = 0; first<len; first++){
            if (nums[first] > 0) break;
            if (first>0 && nums[first] == nums[first-1]) continue;
            int second = first+1;
            int third = len-1;
            while (second<third){
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == 0){
                    res.add(Arrays.asList(nums[first],nums[second],nums[third]));
                    while (second<third && nums[second] == nums[second+1]){
                        second++;
                    }
                    second++;
                    while (second<third && nums[third] == nums[third-1]){
                        third--;
                    }
                    third--;
                }else if(sum<0){
                    second++;
                }else {
                    third--;
                }
            }
        }

        return res;
    }
}
