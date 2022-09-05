package codetop;

import java.util.Arrays;
import java.util.Scanner;

public class 数组组成小于n的最大数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String arrays = sc.nextLine();
        String arr[] = arrays.split(" ");

        String s = String.valueOf(n);
        Arrays.sort(arr);

        boolean flag = false;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i<s.length();++i){
            for(int j = 0; j<arr.length;++j){
                if (flag){
                    res.append(arr[arr.length-1]);
                    break;
                }else if(s.charAt(i) == arr[j].charAt(0)){
                    res.append(arr[j]);
                    break;
                }else if(s.charAt(i) < arr[j].charAt(0)){
                    if (j-1>=0){
                        res.append(arr[j-1]);
                        flag = true;
                        break;
                    }else {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(res.toString());
    }

    public static int getMaxNum(int[] nums, String digit){
        StringBuffer sbf = new StringBuffer();
        //用于标记之后位是否可以直接取最大值
        boolean flag = false;
        Arrays.sort(nums);

        //从目标数字的第一个字符开始，一个一个取
        for (int i = 0; i < digit.length(); i++) {
            if (flag) {
                sbf.append(nums[nums.length - 1]);
                continue;
            }
            //当前位的数字
            int target = digit.charAt(i) - '0';
            //已经走到了最后一轮，则本轮不能选相等的，找小于等于target-1的数即可
            if (i == digit.length() - 1) {
                target = target - 1;
            }
            //搜索nums中最后一个小于等于target的数
            int temp = binarySearch(nums, target);
            //1.当前位不存在小于等于target的数
            //2.当前位存在小于等于target的数，再具体看是等于还是小于
            if (temp == -1) {
                //两种情况：
                //1.1 现在正处于第一位，则说明后面的位直接取最大值即可，当前位不取值
                //1.2 现在处于后面的位，则需要依次回溯前面位，继续往小了取
                if (i == 0) {
                    flag = true;
                } else {
                    //从上一位开始，取一个更小的数
                    int index = i - 1;
                    int newTemp = -1;
                    while (newTemp == -1 && index >= 0) {
                        //上一位继续取一个比之前取的数小一点的数
                        newTemp = binarySearch(nums, sbf.charAt(index) - '0' - 1);
                        //由于上一位必定要换一个数填，则直接从sb中删除
                        sbf.deleteCharAt(index);
                        index--;
                    }
                    //前面所有位都找不到更小的数了，则最终结果就是除了第一位，后面位全部取最大值
                    if (newTemp == -1) {
                        //简化处理，i回到第一位，并触发flag，后面所有位填最大值
                        i = 0;
                        flag = true;
                        continue;
                    }
                    //此时说明回溯时某一位找到更小的值了，则此时后面所有位都应该是最大值，先把这个值加入sb
                    sbf.append(newTemp);
                    //从找到更小数的这位的下一位开始，一直到i，都赋成最大值。由于之前index多减了一次，所以这里是index+2
                    for (int j = index + 2; j <= i; j++) {
                        sbf.append(nums[nums.length - 1]);
                    }
                    //触发flag，后面所有位填最大值
                    flag = true;
                }
            }else{
                //等于，直接加，判下一位
                if(temp == target){
                    sbf.append(temp);
                }else{
                    //小于，//触发flag，后面所有位填最大值
                    sbf.append(temp);
                    flag = true;
                }
            }
        }
        if(sbf.length() == 0){

            return -1;
        }
        return Integer.parseInt(sbf.toString());
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (right + left)/2;
            if (nums[mid] <= target){
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return nums[left] <= target ? nums[left] : -1;
    }
}
