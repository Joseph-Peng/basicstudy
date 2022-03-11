package lc000to050;

public class LC033_搜索旋转数组 {

    public int search(int[] nums, int target) {
        int l = 0, h = nums.length-1;
        // 4 5 6 7 0 1 2 3
        while (l<=h){
            int mid = l + (h - l) / 2;
            if (nums[mid] == target){
                return mid;
            }else if(nums[0]<=nums[mid]){ // 0-mid有序
                if (target>=nums[0] && target<nums[mid]){
                    h = mid -1;
                }else {  // target大于mid
                    l = mid+1;
                }
            }else {   // mid<nums[0]   0-mid无序  mid-nums.length-1有序
                if (target>nums[mid] && target<=nums[nums.length-1]){ // 在有序区间
                    l = mid+1;
                }else {  // 在0-mid中
                    h = mid-1;
                }
            }
        }
        return -1;
    }
}
