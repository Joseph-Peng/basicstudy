package lc201to300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC207_课程表 {

    public static void main(String[] args) {
        int[][] pre = {{1,4},{2,4},{3,1},{3,2}};
        System.out.println(canFinish1(5, pre));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int cnt = 0;
        int[] indegree = new int[numCourses];

        return cnt == numCourses;
    }

    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        int cnt = 0;
        int[] indegree = new int[numCourses];

        List<List<Integer>> outdegree = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            outdegree.add(new LinkedList<>());
        }

        for(int[] p : prerequisites){
            indegree[p[0]]++;
            outdegree.get(p[1]).add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; ++i){
            if(indegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int idx = queue.poll();
            cnt++;
            for(int i : outdegree.get(idx)){
                indegree[i]--;
                if(indegree[i] == 0) queue.offer(i);
            }
        }
        return cnt == numCourses;
    }


}
