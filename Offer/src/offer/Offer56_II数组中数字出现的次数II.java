package offer;

public class Offer56_II数组中数字出现的次数II {

    //有限状态自动机
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums){
            one = one^num & ~two;
            two = two^num & ~one;
        }
        return one;
    }

    // 位运算
    public int singleNumber1(int[] nums) {
        int[] count = new int[32];
        for(int num : nums){
            for(int i = 0; i<count.length; ++i){
                if ((num&1) == 1) ++count[i];
                num >>=1;
            }
        }
        int res = 0;
        for(int i = count.length-1; i>=0; --i){
            if (count[i]%3!=0) res|=1;
            res<<=1;
        }
        return res;
    }

}
