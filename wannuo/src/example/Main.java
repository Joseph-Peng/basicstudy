package example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[][] a = new int[n][n];
        for(int i = 0; i<n;++i){
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i<q;++i){
            int t = sc.nextInt();
            int x = sc.nextInt();
            if(t == 1){
                int v = a[x-1][n-1];
                for (int j = n-1; j > 0 ; --j) {
                    a[x-1][j] = a[x-1][j-1];
                }
                a[x-1][0] = v;
            }else{
                int v = a[0][x-1];
                for (int j = 0; j < n-1; j++) {
                    a[j][x-1] = a[j+1][x-1];
                }
                a[n-1][x-1] = v;
            }
        }

        for(int i = 0; i<n;++i){
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
