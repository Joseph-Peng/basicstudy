package AcWing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Joseph Peng
 * @date 2023/4/25 15:54
 */
public class QuickSort {

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        String[] res = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(res[i]);
        }

        quickSort( 0, num - 1, arr);

        for (int i = 0; i < num; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        br.close();

    }

    /*
    9
    1 2 6 3 6 5 7 6 8
    * */
    public static void quickSort(int low, int high, int[] arr) {
        if (low >= high) return;
        int i = low - 1;
        int j = high + 1;

        int temp = arr[low + high >> 1];
        while (i < j) {
            while (arr[++i] < temp);
            while (arr[--j] > temp);
            if (i < j) swap(arr, i, j);
        }
        // 或者是 i  i-1
        // i ~ high 一定是大于等于temp， i-1 一定是小于等于temp
        quickSort(low, j, arr);
        quickSort(j + 1, high, arr);
    }


    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
