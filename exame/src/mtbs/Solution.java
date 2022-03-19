package mtbs;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // 输入数据
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 原价
        int price[] = new int[n];
        // 折扣价
        int discountPrice[] = new int[n];
        for(int i = 0; i<n;++i){
            price[i] = sc.nextInt();
        }
        for(int i = 0; i<n;++i){
            discountPrice[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        // 满减条件
        int[] c = new int[m];
        // 满减金额
        int[] d = new int[m];
        for(int i = 0; i<m;++i){
            c[i] = sc.nextInt();
        }
        for(int i = 0; i<m;++i){
            d[i] = sc.nextInt();
        }
        //输入数据完毕
        // 思路：
        // 1. 使用前缀和统计前i个商品的原价和 与 折扣价和
        // 2. 题中给出满减参数c是从小到大排序，故使用二分查找
        // 3. 查找到c中小于等于商品的原价和的满减规则
        // 4. 然后用原价和，减去满减的金额，判断与折扣价的大小
        // 5. 大于则输出Z，等于输出B，小于输出M
        String res = "";
        int pp = 0, pd = 0;
        for(int i = 0; i<n;++i){
            pp += price[i];
            pd += discountPrice[i];
            int index = binarySearch(c,pp);
            int manJian = pp;
            if (index>=0){
                manJian -= d[index];
            }
            if (pd == manJian) res += "B"; // 满减与折扣一样
            else if (pd < manJian) res += "Z"; // 折扣便宜
            else res += "M";// 满减便宜
        }
        System.out.println(res);
    }

    public static int binarySearch(int[] c, int target){
        int left = 0, right = c.length-1;
        while (left < right){
            int mid = left + (right-left)/2;
            if (c[mid] == target){
                return mid;
            }else if (c[mid] < target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return right;
    }

}
