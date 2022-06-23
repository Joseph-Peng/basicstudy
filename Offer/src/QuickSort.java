import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int nums[] = {100,5,4,3,2,1,6,7,8,9,0,12,34,22,45};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int i = low, j = high;
            int temp = arr[i];
            while (i < j) {
                while (i < j && arr[j] >= temp) --j;
                while (i < j && arr[i] <= temp) ++i;
                swap(arr, i, j);
            }
            // 此时i位置的数一定小于基准值，这也是为什么快速排序要从右边开始的原因
            swap(arr, i, low);
            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
