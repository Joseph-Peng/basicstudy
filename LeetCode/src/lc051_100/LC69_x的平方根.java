package lc051_100;

public class LC69_x的平方根 {

    public int mySqrt1(int x) {
        if (x <= 1) return x;
        int l = 1, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int sqrt = x / mid;
            if(sqrt == mid){
                return mid;
            }else if(sqrt > mid){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return r;
    }

    // 牛顿迭代法
    public int mySqrt(int x) {
        if(x <= 1) return x;
        double C = x, x0 = x;
        while(true){
            double x1 = 0.5 * (x0 + C/x0);
            if(Math.abs(x0 - x1) < 1e-7){
                break;
            }
            x0 = x1;
        }
        return (int)x0;
    }

}
