package lc801to900;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Joseph Peng
 * @date 2022/9/11 17:12
 */
public class LC857_雇佣K名工人的最低成本 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] id = new Integer[n];//Integer才能用Arrays.sort扩展
        for (int i = 0; i < n; i++) {// 工人的身份ID 方便排序和计算
            id[i] = i;
        }
        Arrays.sort(id, (a, b) -> (quality[b] * wage[a] - quality[a] * wage[b]));// 对工人id 按照 单位工作质量最低薪资 升序排序
        double minTotal = 1e9;//最小的k组工人雇佣金 题目最大是1e8
        double totalq = 0.0;// k组工人的总工作时间（质量）
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);//用最大堆留下工作时间(质量)最小的k个人
        for (int i = 0; i < k - 1; i++) {//最大堆先选进k个
            totalq += quality[id[i]];
            pq.offer(quality[id[i]]);
        }
        for (int i = k - 1; i < n; i++) {//循环打擂维持k个，这k个是当前最高时薪下“quality[ID[i]] / wage[ID[i]]”的工作时间最小的k个
            int idx = id[i];
            totalq += quality[idx];// 累加总工作时间(质量)；最高时薪就是当前升序遍历到的，最小的总工作时间就是当前最大堆内的k个人总工作时间
            pq.offer(quality[idx]);//按照升序时薪遍历所有工人，每个工人都加入最大堆，每次加入的工人是最高时薪，说明每个时薪都会遍历到。
            double totalc = ((double) wage[idx] / quality[idx]) * totalq;//计算当前堆内k个人的雇佣金
            minTotal = Math.min(minTotal, totalc);// 选出最小的总雇佣金
            totalq -= pq.poll();// 减去弹出堆的工人的工作时间(质量)
        }
        return minTotal;
    }
}
