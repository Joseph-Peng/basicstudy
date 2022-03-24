package nowcoder.dp;

public class 接雨水 {

    public static void main(String[] args) {
        int[] num = {3,1,2,5,2,4};
        System.out.println(maxWater(num));
    }

    // 使用两个数组记录当前位置的左边最大值和右边最大值
    public static long maxWater(int[] arr){
        long sum = 0;
        int n = arr.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = arr[0];
        maxRight[n-1] = arr[n-1];
        for(int i = 1;i<n;++i){
            maxLeft[i] = Math.max(arr[i],maxLeft[i-1]);
            //System.out.println(maxLeft[i]);
        }
        for(int i = n-2;i>=0;--i){
            maxRight[i] = Math.max(arr[i],maxRight[i+1]);
        }
        for(int i = 1; i<n-1;++i){
            sum+= Math.min(maxLeft[i],maxRight[i]) - arr[i];
        }
        return sum;
    }

    // 优化空间复杂度，使用双指针的方式边走边算
    public static long maxWater1(int[] arr){
        long sum = 0;
        int n = arr.length;
        int left = 0, right = n-1;
        int lMax = arr[0];
        int rMax = arr[n-1];
        while (left<=right){
            lMax = Math.max(lMax,arr[left]);
            rMax = Math.max(rMax,arr[right]);
            if (lMax<rMax){
                sum += lMax - arr[left];
                left++;
            }else {
                sum += rMax - arr[right];
                right--;
            }
        }
        return sum;
    }

}
