package codetop;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Joseph Peng
 * @date 2022/8/29 15:53
 */
public class 小于K的最大数 {

    public static void main(String[] args) {
        int nums[] = {2, 8, 9};
        //System.out.println("2222 -->" + getMaxNum(nums, "2222") );
        //System.out.println("2999 -->" + getMaxNum(nums, "2999"));
        System.out.println("289 -->" + getMaxNum(nums, "289"));
        //System.out.println("11111 -->" + getMaxNum(nums, "11111") );
        //System.out.println("2345 -->" + getMaxNum(nums, "2345") );
        //System.out.println("1234 -->" + getMaxNum(nums, "1234") );
        //System.out.println("1 -->" + getMaxNum(nums, "1") );
    }

    public static int getMaxNum(int[] nums, String n) {
        StringBuffer num = new StringBuffer(n);
        Arrays.sort(nums);
        int idx = dfs(0, num, nums);
        for(int i = idx + 1; i < n.length(); ++i){
            num.setCharAt(i, (char) (nums[nums.length - 1] + '0'));
        }
        if (idx == -1){
            if (n.length() == 1){
                return -1;
            }
            num.deleteCharAt(num.length() - 1);
        }
        return Integer.parseInt(num.toString());
    }

    /**
     * 从大到小遍历arr，
     * 1. 如果遇到当前位大于arr中的值，由于当前arr[i]是符合条件的最大值
     * 那么就可以将这一位设置为arr[i],并返回已经填补的下标，后续都可以用arr中的最大值填补
     * 2. 如果等于，就处于待定状态，继续dfs，找当前位大于arr中的值，如果找到了就返回idx，
     * 否则就直接返回-1，全部使用arr[arr.length-1]来填补。
     * 最后再getMaxNum中根据返回的idx的值，进行后续处理
     * @param index 遍历到的位置
     * @param num
     * @param arr
     * @return
     */
    public static int dfs(int index, StringBuffer num, int[] arr) {
        // 出口
        if (index == num.length()){
            return -1;
        }
        int d = num.charAt(index) - '0';
        for(int i = arr.length-1; i>=0; --i){
            if(arr[i] < d){
                num.setCharAt(index, (char) (arr[i] + '0'));
                return index;
            }else if(arr[i] == d){
                int idx = dfs(index + 1, num, arr);
                if (idx >= 0) return idx;
            }
        }
        return -1;
    }

}
