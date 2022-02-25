package bytedance;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 穿越沙漠的补给次数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int D = in.nextInt();
        int W = in.nextInt();
        in.nextLine();
        String ps = in.nextLine();
        String ss = in.nextLine();

        String[] ps1 = ps.split(" ");
        String[] ss1 = ss.split(" ");
        int n = ps1.length;
        int[] position = new int[n];
        int[] supply = new int[n];

        for(int i = 0; i<n; ++i){
            position[i] = Integer.parseInt(ps1[i]);
            supply[i] = Integer.parseInt(ss1[i]);
        }

        System.out.println(minCount(D,W,position,supply));
    }

    /*
    * 12  4
    * 1 7 8 9
    * 2 5 6 7
    * 3 1 1 1
    * */

    private static int minCount(int d, int w, int[] position, int[] supply) {
        int ans = 0;
        if (w>d) return 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((x,y)->(y-x));
        int curWater = w;
        int preLocation = 0;
        for(int i = 0; i < position.length; ++i){
            curWater -= position[i] - preLocation;
            /*System.out.println(curWater);*/
            while (!queue.isEmpty() && curWater<0){
                curWater += queue.poll();
                ans++;
            }
            if (curWater<0) return -1;
            queue.offer(supply[i]);
            preLocation = position[i];
        }
        curWater -= d - preLocation;
        while (curWater<0 && !queue.isEmpty()){
            curWater += queue.poll();
            ans++;
        }

        return curWater>=0? ans : -1;
    }
}
