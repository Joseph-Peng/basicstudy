package wy;
import java.util.Scanner;
import java.util.*;
import java.util.Scanner;
import java.util.*;

public class Main {

    public static int minStep = 0;
    public static int eCount = 0;
    public static int[] e;
    public static char[][] matrix2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            int N = sc.nextInt();  // 行
            int M = sc.nextInt();  // 列
            int f = sc.nextInt();  // 友军数量
            int d = sc.nextInt();  // 敌人数量

            e = new int[f];  // 每个友军的能量
            for (int j = 0; j < f; ++j) {
                e[j] = sc.nextInt();
            }
            sc.nextLine();
            int[][] position = new int[f][2]; // 记录友军的位置
            char[][] matrix = new char[N][M];
            for (int j = 0; j < N; ++j) {
                matrix[j] = sc.nextLine().toCharArray();
                for (int k = 0; k < matrix[j].length; ++k) {
                    if ('0' <= matrix[j][k] && matrix[j][k] <= '9') {
                        position[matrix[j][k] - '0'] = new int[]{j, k};
                    }
                }
            }
            matrix2 = matrix;
            if (f < d) {
                System.out.println(-1);
                return;
            }
            int min = Integer.MAX_VALUE;
            boolean visitedF[] = new boolean[f];
            // 每次选择一个友军
            // 先计算这个友军能否消灭敌人，能消灭就将敌人数减1，并记录步数
            // 再计算其他友军
            for (int j = 0; j < f; ++j) {
                matrix = matrix2;
                eCount = d;
                minStep = 0;
                //System.out.println(e[j]);
                dfs(matrix, N, M, e[j], position[j][0], position[j][1], visitedF, position, j,eCount);
                if (eCount == 0) {
                    min = Math.min(min, minStep);
                }
            }
            //System.out.println(eCount);
            System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        }
    }

    /*
1
4 4 2 2
4 4
0++1
EWW+
+WW+
+E++

     */
    private static void dfs(char[][] matrix, int n, int m, int ej, int i, int j, boolean[] visitedF, int[][] positions, int index,int count) {
        if (visitedF[index]) return;
        visitedF[index] = true;
        move(matrix, n, m, ej, i, j,index);
        if (eCount == count){
            visitedF[index] = false;
            return;
        }
        for (int k = 0; k < visitedF.length; ++k) {
            if (!visitedF[k]) {
                //System.out.println("k = "+k);
                dfs(matrix, n, m, e[k], positions[k][0], positions[k][1], visitedF, positions, k,count);
            }
        }
    }

    private static void move(char[][] matrix, int n, int m, int ej, int i, int j, int index) {
        if (ej == 0) {
            if (matrix[i][j] == 'E'){
                minStep += e[index];
                eCount--;
                matrix[i][j] = '+';
                //System.out.println(minStep);
                //System.out.println("ecount = " + eCount);
            }
            return;
        }else if(matrix[i][j] == 'E' || matrix[i][j] == 'W'){
            return;
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] dir : directions){
            int newI= i+dir[0];
            int newJ = j+dir[1];
            if (newI>=0 && newI<n && newJ>=0 && newJ<m){
                move(matrix,n,m,ej-1,newI,newJ,index);
            }
        }
    }
}