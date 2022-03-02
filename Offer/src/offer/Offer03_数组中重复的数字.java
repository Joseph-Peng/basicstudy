package offer;

public class Offer03_数组中重复的数字 {

    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }

    /**
     * 采用原地交换的思路
     * 1. 当前下标位置的数nums[i]和下标位置相等 i++
     * 2. 当前下标位置的数nums[i]和下标位置不相等，就交换nums[nums[i]]和nums[i]
     * 3. 如果遇到nums[i]!=i && nums[nums[i]] == nums[i]就返回当前值
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums){
        int i = 0;
        while (i<nums.length){
            while (nums[i]!=i){
                if(nums[i] == nums[nums[i]]) return nums[i];
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
            i++;
        }
        return -1;
    }

}
