import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int nums[] = {100,5,4,3,2,1,6,7,8,9,0,12,34,22,45};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void heapSort(int[] arr){
        if (arr == null || arr.length==0) return;

        int len = arr.length;
        // 构建大顶堆
        buildMaxHeap(arr,len);

        // 调整堆结构，交换堆顶元素和末尾元素
        for (int i = len -1; i>=0; --i){
            swap(arr,0,i);
            heapify(arr,0,i);
        }

    }

    public void buildMaxHeap(int[] arr, int len){
        // 从最后一个非叶节点开始向前遍历，找到它和它子节点中最大的值
        for(int i = len/2; i>=0; --i){
            heapify(arr, i, len);
        }
    }

    public void heapify(int[] arr, int i, int len) {
        // 计算左右子节点的下标
        int left = 2*i+1;
        int right = 2*(i+1);
        int largestIndex = i;
        if (left<len && arr[left] > arr[largestIndex]){
            largestIndex = left;
        }

        if(right<len && arr[right] > arr[largestIndex]){
            largestIndex = right;
        }
        if (largestIndex!=i){
            swap(arr,largestIndex,i);
            heapify(arr,largestIndex,len);
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
