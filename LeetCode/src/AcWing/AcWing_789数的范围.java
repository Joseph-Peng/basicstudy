package AcWing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Joseph Peng
 * @date 2023/4/26 10:11
 */
public class AcWing_789数的范围 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1[] = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int q = Integer.parseInt(line1[1]);
        String nums[] = br.readLine().split(" ");
        int arr[] = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        for (int i = 0; i < q; ++i) {
            int k = Integer.parseInt(br.readLine());
            boundarySearch(arr, k);
        }

        br.close();
    }

    private static void boundarySearch(int[] arr, int k) {
        // 先找右边界
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int mid = i + j >> 1;
            if (arr[mid] <= k) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int right = i;
        if (right == 0 || arr[right - 1] != k) {
            System.out.println("-1 -1");
            return;
        }

        // 再找左边界
        i = 0;
        j = right;
        while (i <= j) {
            int mid = i + j >> 1;
            if (arr[mid] >= k) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        System.out.println((j+1) + " " + (right-1));
    }
}
