package offer;

public class Offer11_旋转数组的最小数字 {

    public static void main(String[] args) {
        int nums[] = {3,4,5,1,2};
        System.out.println(minArray(nums));
    }

    /**
     * 数组分为两个升序段
     * 二分查找  mid   i = 0, j = numbers.length-1
     * 如果numbers[mid]<numbers[j]  说明mid在后面的升序段，那么j = mid  之所以不是mid-1是为了不跳过最小的
     * 如果numbers[mid]>numbers[j]  说明mid在前面的升序段，那么i = mid+1
     * 如果numbers[mid] == numbers[j]  那么j = j-1
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers){
        int i = 0, j = numbers.length-1;
        while (i<=j){
            int mid = i+(j-i)/2;
            if (numbers[mid]<numbers[j]) j = mid;
            else if (numbers[mid]>numbers[j]) i = mid+1;
            else j--;
        }
        return numbers[i];
    }
}
