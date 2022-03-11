package offer;

public class Offer43_1到n中1出现的次数 {

    /**
     * 计算每一位出现1的次数，然后求和
     * 将一个整数分为高 当前 低 三部分
     * 例如   1234567
     * 假设我们求百位1出现的次数，那么百位就位当前位  cur = 5
     * high = 1234   low = 67
     * 先算高位：100-999中百位出现1的次数为100  ->1234*100个1(高位)
     * 再算低位：
     * cur = 0 则百位无1 加0
     * cur = 1 则出现1的次数为  low+1
     * cur>1  则加100
     * 再将高位低位计算出来的结果相加可得百位出现1的次数
     * 在分别求十位、千位等，加起来求和就是1-n中1出现的次数
     */
    public int countDigitOne(int n) {
        int ans = 0;
        int high = n/10, cur = n%10, low = 0, digit = 1;
        while(n>0){
            if(cur == 0) ans += high*digit;
            else if(cur == 1) ans += high*digit + low + 1;
            else ans += (high+1)*digit;
            n/=10;
            low = cur*digit + low;
            high = n/10;
            cur = n%10;
            digit*=10;
        }
        return ans;
    }

    public int countDigitOne1(int n) {
        // 先从各位求起
        int high = n/10, cur = n%10, low = 0;
        int digit = 1, res = 0;
        while(high!=0 || cur!=0){
            if(cur==0) res += digit*high;
            else if (cur==1) res += high*digit + low +1;
            else res += (high+1)*digit;
            low += cur * digit;
            cur = high%10;
            high = high/10;
            digit*=10;
            //low = n%digit;
        }
        return res;
    }
}
