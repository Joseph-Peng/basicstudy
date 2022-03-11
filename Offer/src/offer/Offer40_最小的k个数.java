package offer;

import java.util.Arrays;

public class Offer40_最小的k个数 {

    public int[] getLeastNumbers(int[] arr, int k){
        if (k>=arr.length) return arr;
        return quickSort(arr,0,arr.length-1,k);
    }

    private int[] quickSort(int[] arr, int l, int r, int k) {
        int i = l, j = r;
        while (i<j){
            while (i<j && arr[j]>=arr[l]) --j;
            while (i<j && arr[i]<=arr[l]) ++i;
            swap(arr,i,j);
        }
        swap(arr,i,l);
        if (i>k) return quickSort(arr,l,i-1,k);
        else if (i<k) return quickSort(arr,i+1,r,k);
        return Arrays.copyOf(arr,k);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
