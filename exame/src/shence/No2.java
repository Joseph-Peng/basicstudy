package shence;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;

/**
 * @author Joseph Peng
 * @date 2022/8/13 9:54
 */
public class No2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] timeStr = str.split(" ");
        Arrays.sort(timeStr);
        long[] timeStamp = convert(timeStr, n);
        long max = timeStamp[0] - timeStamp[n-1] + 24*60*60;
        int resIdx = n-1;
        for(int i = 1; i < n;++i){
            if(timeStamp[i] - timeStamp[i-1] > max){
                max = timeStamp[i] - timeStamp[i-1];
                resIdx = i-1;
            }
        }

        System.out.println(timeStr[resIdx]);
    }

    private static long[] convert(String[] timeStr, int n) {
        long[] res = new long[n];
        for(int i = 0; i < timeStr.length; ++i){
            String[] segment = timeStr[i].split(":");
            res[i] = Integer.parseInt(segment[0])*3600 +
                    Integer.parseInt(segment[1])*60+
                    Integer.parseInt(segment[0]);
        }
        return res;
    }
}
