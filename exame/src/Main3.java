import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[][] = new int[n][2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<n;++i){
            for (int j = 0;j<2;j++){
                a[i][j] = sc.nextInt();
                map.put(a[i][j],1);
            }
        }
        /*Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });*/
        int count = 0;
        int right = a[0][1];
        for(int i = 1; i<n;++i){
            if (map.get(a[i][0])==1 && map.get(a[i][1])==1){
                count++;
                map.put(a[i][0],0);
                map.put(a[i][1],0);
            }
        }
        System.out.println(n-count);
        /*for (int i = 0;i<n;++i){
            for (int j = 0;j<2;j++){
                System.out.print(a[i][j] +" ");
            }
            System.out.println();
        }*/
    }
}
