package bytedance;

import java.util.Scanner;

public class B2019RobotJump {
    //https://www.nowcoder.com/questionTerminal/7037a3d57bbd4336856b8e16a9cafd71?f=discussion



    /*如果是H(k+1) > E ，假设跳跃后为E2，有 E2 = E - (H(k+1) - E) = 2E - H(K+1);
    如果是H(k+1) <= E，假设跳跃后为E2，有 E2 = E + (E - H(k+1)) = 2E - H(K+1);
    无论哪种情况，最终都有 E2 = 2E - H(K+1)； -> E = (E2 + H(k+1) + 1)/2 -> 加一是为了向上取整。*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }
        int result = 0;
        for(int i = n-1; i>=0;--i){
            result = (result + h[i] +1)/2;
            System.out.println(result);
        }
        System.out.println(result);
    }

}
