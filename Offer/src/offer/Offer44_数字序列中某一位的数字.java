package offer;

public class Offer44_数字序列中某一位的数字 {

    /*  位数
    1       1*9
    2       2*90
    3       3*900
    1. 先确定位数
    2. 再确定是当前位数的第几个数
    3. 再确定是当前数的第几位*/
    public int findNthDigit(int n) {
        if (n<10) return n;
        int digit = 1;
        long count = 9, start = 1;
        while (n>0){
            n-=count;
            start *= 10;
            digit++;
            count = digit*start*9;
        }

        // num就是包含n的整数
        // 这里取n-1的原因是:当n对应num中的最后一位时，不会由于进位，错误的寻找到下一个数字。
        // 例如n=15 经过while后   n=6, start = 10, digit = 2
        // 10 11 12 13
        // 如果直接n/2的话会导致 num = 10+3 = 13  实际上应该是12的2(注意n=1时是1)
        long num = start + (n-1)/digit;
        // 此处的n-1是因为转化为String后下标是从0开始的
        return Long.toString(num).charAt((n-1)%digit) - '0';
    }
}
