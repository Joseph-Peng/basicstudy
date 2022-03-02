package codetop;

public class 快熟幂 {

    public static void main(String[] args) {
        System.out.println(myPow(2,10));
        System.out.println(myPow(2.0,10));
    }

    public static long myPow(int a, int n){
        long res = 1;
        while (n>0){
            if ((n&1) == 1) res *= a;
            n>>=1;
            a = a*a;
        }
        return res;
    }

    public static double myPow(double x, int n) {
        if(n==0) return 1;
        int t = Math.abs(n);
        System.out.println(t);
        double res = 1.0;
        while(t>0){
            if((t&1) == 1) res*=x;
            t>>=1;
            x = x*x;
        }
        return n>0? res:1/res;
    }
}
