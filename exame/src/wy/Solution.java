package wy;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        int[]p = {5, 5, 6, 6, 10, 10, 10};
        int[][]d = {{0, 1, 5}, {1, 0, 2}, {5, 1, 0}};
        System.out.println(getMinimumTime(p,d));

    }

    public static int getMinimumTime (int[] productList, int[][] drivingTimes) {
        List<Integer> vectors = new ArrayList<>();
        vectors.add(0);
        int[] finalDis = new int[drivingTimes.length];
        finalDis = drivingTimes[0];
        while (vectors.size()!=drivingTimes.length){
            int minVector = getMinVector(finalDis,vectors);
            int minDis = finalDis[minVector];
            for(int i = 0; i < drivingTimes.length;++i){
                if(vectors.contains(Integer.valueOf(i))) continue;
                if (drivingTimes[minVector][i]==-1) continue;
                if (drivingTimes[minVector][i] + minDis < finalDis[i] || finalDis[i] == -1){
                    finalDis[i] = drivingTimes[minVector][i] + minDis;
                }
            }
        }
        int cost = finalDis[drivingTimes.length-1];
        //计算次数
        int total = 0;
        for (int num : productList){
            total+=num;
        }
        int time = total/40;
        if (total%40 != 0) time+=1;
        //System.out.println(2*(time-1)*cost+cost);
        return 2*(time-1)*cost+cost;
    }

    private static int getMinVector(int[] finalDis, List<Integer> vectors){
        int min = Integer.MAX_VALUE;
        int minVector = -1;
        for(int i = 0; i<finalDis.length;++i){
            if (finalDis[i]!=-1 && finalDis[i] < min && !vectors.contains(Integer.valueOf(i))){
                min = finalDis[i];
                minVector = i;
            }
        }
        vectors.add(minVector);
        return minVector;
    }
}
