package tecent;

import java.util.*;


public class Solution {

    public static void main(String[] args) {
        System.out.println(numsOfStrings(4,2));
    }

    public static int count = 0;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n int整型
     * @param k int整型
     * @return int整型
     */
    public static int numsOfStrings(int n, int k) {
        // 3 2
        if (n  < 2*k) {
            return 0;
        }
        int sum = 1;
        for (int i = 0; i < k; ++i) {
            if (i == 0) sum = (sum * 26) % 1000000;
            else sum = (sum * 25) % 1000000;
        }
        int maxLen = n-2*(k-1);
        bfs(n,maxLen,k);
        //System.out.println(count);
        return sum*count%1000000;
    }

    /*public static int numsOfStrings(int n, int k) {
        if (n  < 2*k) {
            return 0;
        }
        long a = Math.pow(25,k-1)*26
    }*/

    public static void bfs(int target, int t,int k){
        if (target == 0 && k==0) {
            count++;
            return;
        }
        if (k==0) return;
        if (target<2) return;
        for(int i = 2; i<=t;++i){
            bfs(target-i,t,k-1);
        }
    }

    public int minMax(ArrayList<Integer> a, int k, int x) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((i, j) -> (j - i));
        for (int i = 0; i < a.size(); ++i) {
            queue.offer(a.get(i));
        }
        for (int i = 0; i < k; ++i) {
            int t = queue.poll();
            t -= x;
            queue.offer(t);
        }
        return queue.peek();
    }

    public int minCnt(String s) {
        int time = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                if (flag) {
                    flag = false;
                } else {
                    time++;
                }
            }
        }
        return time;
    }


}