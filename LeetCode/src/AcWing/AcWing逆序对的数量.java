package AcWing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Joseph Peng
 * @date 2023/4/25 18:51
 */
public class AcWing逆序对的数量 {
    static int temp[];

    public static void main(String[] args) throws Exception {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        temp = new int[num];

        String[] res = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(res[i]);
        }
        System.out.println(mergeSort(0, num - 1, arr));
        br.close();
    }

    public static long mergeSort(int l, int r, int[] arr) {
        if (l >= r) return 0;
        int mid = l + r >> 1;
        long res = 0;
        res += mergeSort(l, mid, arr) + mergeSort(mid + 1, r, arr);
        int i = l, j = mid + 1, k = l;
        while (i <= mid && j <= r) {
            if (arr[i] > arr[j]) {
                res += mid - i + 1;
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }

        // 扫尾
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        for (i = l; i <= r; ++i) {
            arr[i] = temp[i];
        }
        return res;
    }
}
