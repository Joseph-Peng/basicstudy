package offer;

public class Offer62_圆圈中最后剩下的数字 {

    // 圆圈中最后剩下的数字  从数字0开始计数
    /*n=8 m=3
    A B C D E F [G] H   // 最后剩下的数字是G
    从后往前推
    A B C D E F G H          // G:6 -> f(8) = 6
        D E F G H A B      //  f(7) = 3
        D E F G H A B      //  f(7) = 3
                G H A B D E  //  f(6) = 0
                B D E G H    //  f(5) = 3
    **理解这个递推式的核心在于关注胜利者的下标位置是怎么变的。
    每杀掉一个人，其实就是把这个数组向前移动了M位。然后逆过来，就可以得到这个递推式。
    最后一次的下标一定为0，那么有两个人时01 删除的人就是(0+m)%2
    */
    public int lastRemaining(int n, int m) {
        int pre = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for(int i = 2;i<=n;i++){
            pre = (pre+m)%i;
        }
        return pre;
    }
}
