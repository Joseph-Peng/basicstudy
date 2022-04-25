package codetop;

import java.util.*;

public class 和为target的子集 {

    // 给定一个数组nums，找出数组中有多少个和为target的子集
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,7,-1}, target = 7;
        int[] dp = new int[target+1];
        Map<Integer,Integer> dict = new HashMap<>();
        int count = 0;
        for(int i = 0; i<nums.length;++i){
            count +=  dict.getOrDefault(target - nums[i],0);
            Set<Integer> sums = new HashSet<>(dict.keySet());
            for(int key : sums){
                dict.put(key + nums[i], dict.getOrDefault(key + nums[i],0)+1);
            }
            dict.put(nums[i], dict.getOrDefault(nums[i],0)+1);
        }
        System.out.println(count);
    }
}
