package codetop;

import java.util.Arrays;
import java.util.Stack;

public class 数组中每个数右边第一个比它大的元素 {

    public static void main(String[] args) {
        int[] nums = {8, 2, 5, 4, 3, 9, 7, 2, 5};
        System.out.println(Arrays.toString(findMaxRight(nums)));
    }


    public static int[] findMaxRight(int[] array) {
        if (array == null || array.length == 0) return array;
        int[] res = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i<array.length; ++i){
            while (!stack.isEmpty() && array[i] > array[stack.peek()]){
                res[stack.pop()] = array[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            res[stack.pop()] = -1;
        }
        return res;
    }
}
