package lc851to900;

import java.util.PriorityQueue;

public class LC871_最少加油次数 {

    public static void main(String[] args) {
        minRefuelStops(10, 4, null);
    }

    // 优先队列
    public static int minRefuelStops(int target, int startFuel, int[][] s) {
        int res = 0;
        if (startFuel >= target) {//初始边界条件
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> (y - x));
        int curFuel = startFuel; // 当前的油量
        int pre = 0;  // 前一个加油站的位置

        for (int i = 0; i < s.length; ++i) { // 遍历加油站
            int location = s[i][0];  // 当前加油站的位置
            int fuel = s[i][1];   // 当前加油站的油量
            curFuel -= (location - pre); // 计算从上一个位置走到这里，还有多少油，当前位置减去上一个位置就是耗油量
            while (curFuel < 0 && !queue.isEmpty()) { // 说明邮箱里的油不足以从上一个加油站到当前加油站，那么从队列中选一个最大的加油
                curFuel += queue.poll();
                ++res; //加了一次油
            }
            if (curFuel < 0) return -1; // 说明我把前面能加的油都加完了还不能到达
            queue.offer(fuel);
            pre = location;
        }
        //遍历完成后，来判断当前的油量能否到达target
        curFuel -= target - pre;
        while (curFuel < 0 && !queue.isEmpty()) {
            curFuel += queue.poll();
            ++res;
        }

        return curFuel >= 0 ? res : -1;
    }
}
