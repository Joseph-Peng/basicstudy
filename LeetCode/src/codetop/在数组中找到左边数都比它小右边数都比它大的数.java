package codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 在数组中找到左边数都比它小右边数都比它大的数 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,0,5,6};
        int[] nums2 = {1,8,6,9,10,15,12,20};
        System.out.println(Arrays.toString(midValue(nums)));
        System.out.println(Arrays.toString(midValue(nums2)));
        System.out.println("--------------------------------------------");
        System.out.println(Arrays.toString(midValue2(nums)));
        System.out.println(Arrays.toString(midValue2(nums2)));
    }

    private static int[] midValue(int[] nums){
        if(0 == nums.length) {return null;}
        // 存储当前满足条件的值
        Stack<Integer> midNumsStack = new Stack<>();
        // 记录当前遍历过的最大值(新入栈的数必须不小于max)
        int max = nums[0];
        midNumsStack.push(nums[0]);
        for(int i=1; i<nums.length; i++){
            // 先检查新值num是否小于栈内元素, 否则栈内元素不满足条件
            while(!midNumsStack.empty() && nums[i] <= midNumsStack.peek()){
                midNumsStack.pop();
            }
            if(nums[i] > max){
                midNumsStack.push(nums[i]);
                max = nums[i];
            }
        }
        int[] result = new int[midNumsStack.size()];
        int i = 0;
        while(midNumsStack.size()>0){
            result[i++] = midNumsStack.pop();
        }
        return result;
    }

    // 方法2，两次遍历
    private static int[] midValue2(int[] nums){
        if(nums == null || 0 == nums.length) {return nums;}

        // 维护一个单调数组，存放的是每个位置及其之后的最小值
        int[] rightMin = new int[nums.length];
        int len = nums.length;
        int rMin = nums[len-1];
        for(int i = len-1; i>=0; --i){
            if(nums[i] < rMin) rMin = nums[i];
            rightMin[i] = rMin;
        }
        List<Integer> res = new ArrayList<>();
        //接下来从左往右遍历，如果下标i处的值小于rightMin[i+1]处的值，并且比当前遍历过的max值更大
        // 那么当前值符合条件
        int max = nums[0];
        for(int i = 0; i < len; ++i){
            if (nums[i]>=max){
                max = nums[i];
                if(i == len-1 && nums[i] == rightMin[i]) {
                    res.add(nums[i]);
                    break;
                }
                //如果下标i处的值小于rightMin[i+1]处的值
                if (nums[i] < rightMin[i+1]) res.add(nums[i]);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; ++i){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
