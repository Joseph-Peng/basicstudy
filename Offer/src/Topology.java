import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Topology {
    //degree[i]表示节点i的入度
    // outdegree[i]表示节点i指向的节点
    public void topology(int[] degree, int[][] outdegree){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < degree.length; ++i){
            if (degree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()){
            int curNode = queue.poll();
            for(int idx : outdegree[curNode]){
                degree[idx]--;
                if(degree[idx] == 0) queue.offer(idx);
            }
        }
    }
}
