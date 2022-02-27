package tecent;

public class 细胞分裂问题 {

    public int count(int n){
        if (n==0) return 1;
        if (n==1) return 2;
        if (n==2) return 4;
        if (n==3) return 7;
        return count(n-1)*2 - count(n-4);
    }
}
