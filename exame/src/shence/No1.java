package shence;

import java.util.Scanner;

/**
 * @author Joseph Peng
 * @date 2022/8/13 9:54
 */
public class No1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0; i<n; ++i){
            for(int j = 0; j < n; ++j){
                matrix[i][j] = sc.nextInt();
            }
        }
        int i = 0, j = 0;
        int t = 0;
        while (t <= 2*n - 1){
            if(t%2==0){
                while(i >= 0 && j < n){
                    System.out.print(matrix[i][j]+" ");
                    i = i-1;
                    j = j+1;
                }
                i = i+1;
                if(j >= n){
                    j = n-1;
                    i = i+1;
                }
            }else{
                while (i < n && j >= 0){
                    System.out.print(matrix[i][j]+" ");
                    i = i+1;
                    j = j-1;
                }
                j = j+1;
                if(i >= n){
                    i = n-1;
                    j = j+1;
                }
            }
            ++t;
        }
    }
}
