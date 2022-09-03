package lc151to200;

/**
 * @author Joseph Peng
 * @date 2022/8/28 21:16
 */
public class LC175_阶乘后的0 {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0){
            count += n/5;
            n/=5;
        }
        return count;
    }

}
