import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 房间数
        int m = sc.nextInt(); // 秒数
        int a[] = new int[m];
        int[] boom = new int[n];
        for (int i = 0; i<m;++i){
            a[i] = sc.nextInt();
            boom[a[i]-1]++;
        }

        int res = 0;
        int room = 1;
        for (int i = 0; i<m;++i){
            boom[a[i]-1]--;
            if (a[i] == room) {
                room = findMin(boom,room);
                res++;
                //System.out.println(room);
            }
        }
        System.out.println(res);
    }

    private static int findMin(int[] boom, int room) {
        int roomIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<boom.length;++i){
            if (i+1!=room && boom[i]<min) {
                min = boom[i];
                roomIndex = i+1;
            }
        }
        return roomIndex;
    }
}
