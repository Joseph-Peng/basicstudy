package lc051_100;

public class LC69_x的平方根_精确到指定位的小数 {

    public static void main(String[] args) {
        System.out.println(sqrt(8));
    }

    //二分法进行处理，注意变量类型
    public static double sqrt(int target) {
        double n = 1e-2;            //在这里可根据精度要求进行调整
        double l = 1, r = target;      //这里若初始化r=target/2的话，则处理较小正整数会出错，如1,2
        while (l <= r) {              //二分查找
            double mid = (l + r) / 2;
            //这里用除法，而不用mid*mid与target比较，是防止mid过大时，mid*mid产生溢出问题
            double sqrt = target / mid;
            if (sqrt == mid) return mid;
            if (target / mid < mid) {
                r = mid - n;
            } else {
                l = mid + n;
            }
        }
        return r;
    }

}
