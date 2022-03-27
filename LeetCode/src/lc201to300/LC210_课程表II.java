package lc201to300;

import java.util.LinkedList;
import java.util.Queue;

public class LC210_课程表II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        int[] inDegree = new int[numCourses];
        for(int[] p : prerequisites){
            inDegree[p[0]]++;
        }

        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i<inDegree.length;++i){
            if (inDegree[i] == 0) queue.offer(i);
        }

        int count = 0; // // 记录可以学完的课程数量
        int[] res = new int[numCourses];
        // 根据提供的先修课列表，删除入度为 0 的节点
        while (!queue.isEmpty()){
            int cur = queue.poll();
            res[count++] = cur;
            for(int[] p : prerequisites){
                if (p[1] == cur){
                    inDegree[p[0]]--;
                    if (inDegree[p[0]] == 0) queue.offer(p[0]);
                }
            }
        }
        if (count == numCourses) return res;
        return new int[0];
    }
}
