package offer;

@SuppressWarnings("all")
public class Offer46_把数字翻译成字符串 {

    /*
             f(i-1)+f(i-2)    如果i和i-1组成的数组在[10,25]的范围内
    f(i) =
             f(i-1)           其他情况
     例如：
     初始状态：dp[0]=dp[1]=1 ，即 “无数字” 和 “第 11 位数字” 的翻译方法数量均为 11 ；
     1235
     1  1种
     12  12属于[10,25]  --->  1+1 = 2种
     123 同理  3种   --->  f(1) + f(2) = 3种   bcd、md、bx三种
     1235  35不属于[10,25]  =  3种  因为5只能翻译成5，没有其他情况
     */
    // 不使用字符串额外的空间，因为此题动态规划是对称的
    public int translateNum(int num) {
        int p = 1, pp =1;
        while (num>0){
            int a = num%10;
            num/=10;
            int b = num%10;
            int c = (b*10+a>=10 && b*10+a<=25)? pp+p : p;
            pp = p;
            p = c;
        }
        return p;
    }

    public int translateNum1(int num) {
        int p = 1, pp =1;
        String s = String.valueOf(num);
        for(int i = 2; i<=s.length(); ++i){
            int n = Integer.parseInt(s.substring(i-2,i));
            int c = (n>=10 && n<=25)? p+pp:p;
            pp = p;
            p = c;
        }
        return p;
    }

}
