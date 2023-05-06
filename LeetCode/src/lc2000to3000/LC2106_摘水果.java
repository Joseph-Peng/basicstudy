package lc2000to3000;

/**
 * @author Joseph Peng
 * @date 2023/5/4 9:55
 */
public class LC2106_摘水果 {

    /**
     二分法：
     1. 从startPos向左或向右走k步
     2. 从startPos向左走x步，向右走k-x步
     3. 从startPos向右走x步，向左走k-x步
     找出这三种情况中最大的，就是可以摘到的水果最大总数
     技巧：
     1. 可以转化为能走到的范围内的最大水果数，[startPos - x, startPos + k - 2x] (先向左x，在向右k-x；先向右同理)
     当x=0时表示朝某一个方向走k步。
     2. 计算一个范围内的总数，可以使用前缀和快速计算

     */
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int len = fruits.length;
        // 1. 计算前缀和
        int[] sum = new int[len+1];
        // 2. 将水果的坐标记录在数组中，便于二分查找
        int[] pos = new int[len];
        for(int i = 1; i <= len; ++i){
            sum[i] = sum[i-1] + fruits[i-1][1];
            pos[i-1] = fruits[i-1][0];
        }

        int ans = 0;
        // 3. 开始模拟移动
        for(int x = 0; x <= k / 2; ++x){
            int y = k - 2*x;
            // 模拟先向左走x步，向右走k-x步
            int left = startPos - x;
            int right = startPos + y;
            //二分查找第一个大于等于target的数组下标
            int start = lowerBounder(pos,  0, len - 1, left);
            // 二分查找第一个大于target的数组下标
            int end = upperBound(pos,  0, len - 1, right);
            ans = Math.max(ans, sum[end] - sum[start]);

            // 模拟先向右走x步，再向左走k-x步
            left = startPos - y;
            right = startPos + x;
            //二分查找第一个大于等于target的数组下标
            start = lowerBounder(pos,  0, len - 1, left);
            // 二分查找第一个大于target的数组下标
            end = upperBound(pos,  0, len - 1, right);
            ans = Math.max(ans, sum[end] - sum[start]);
        }

        return ans;
    }

    //二分查找第一个大于等于target的数组下标
    public int lowerBounder(int[] arr, int left, int right, int target){
        int i = left, j = right;
        while(i <= j){
            int mid = i + j >> 1;
            if(arr[mid] < target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return i;
    }

    // 二分查找第一个大于target的数组下标
    public int upperBound(int[] arr, int left, int right, int target){
        int i = left, j = right;
        while(i <= j){
            int mid = i + j >> 1;
            if(arr[mid] <= target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return i;
    }
}
