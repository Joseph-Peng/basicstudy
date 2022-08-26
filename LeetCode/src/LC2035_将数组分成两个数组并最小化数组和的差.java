import java.util.Arrays;

/**
 * @author Joseph Peng
 * @date 2022/8/20 21:58
 *
 * https://blog.csdn.net/shanshanhi/article/details/67639562  // 非本题解法
 *
 */
public class LC2035_将数组分成两个数组并最小化数组和的差 {

    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int sum = Arrays.stream(nums).sum();
        int[] A = new int[n];
        int[] B = new int[n];
        return 100;
    }

}
