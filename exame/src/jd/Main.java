package jd;

import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        double[] res = new double[nums.length - k + 1];
        int[] window = new int[k];
        //添加初始值
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }

        Arrays.sort(window);
        double mid = getMid(window);
        double a = mid - window[0];
        double b = window[k-1] - mid;
        if(a > b){
            res[0] = window[0];
        }else {
            res[0] = window[k-1];
        }
        for (int i = 0; i < nums.length - k; i++) {
            int index = search(window, nums[i]);
            window[index] = nums[i + k];
            while (index < window.length - 1 && window[index] > window[index + 1]) {
                swap(window, index, index + 1);
                index++;
            }
            while (index > 0 && window[index] < window[index - 1]) {
                swap(window, index, index - 1);
                index--;
            }
            mid = getMid(window);
            a = mid - window[0];
            b = window[k-1] - mid;
            if(a > b){
                res[i + 1] = window[0];
            }else {
                res[i + 1] = window[k-1];
            }
        }
        StringBuffer ans = new StringBuffer();
        ans.append("[");

        for (int i = 0; i < res.length; ++i){
            ans.append((int) res[i] + ", ");
        }
        ans.deleteCharAt(ans.length()-1);
        ans.deleteCharAt(ans.length()-1);
        ans.append("]");
        System.out.println(ans.toString());
    }

    //求数组的中位数
    private static double getMid(int[] window) {
        int len = window.length;
        if (window.length % 2 == 0) {
            //避免溢出
            return window[len / 2] / 2.0 + window[len / 2 - 1] / 2.0;
        } else {
            return window[len / 2];
        }
    }

    //交换
    private static void swap(int[] window, int i, int j) {
        int temp = window[i];
        window[i] = window[j];
        window[j] = temp;
    }

    //最简单的二分查找
    private static int search(int[] window, int target) {
        int start = 0;
        int end = window.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (window[mid] > target) {
                end = mid - 1;
            } else if (window[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
// [2452, 2452, 2452, 1284]