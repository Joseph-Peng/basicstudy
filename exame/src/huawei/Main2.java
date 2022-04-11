package huawei;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0;i<T;++i){
            int n = sc.nextInt(); // 人数
            int m = sc.nextInt(); // 咖啡机的数量
            int x = sc.nextInt(); // 洗一个杯子的时间
            int y = sc.nextInt(); // 咖啡自然挥发的时间
            int[] zhu = new int[m];
            for(int j = 0;j<m;j++){
                zhu[j] = sc.nextInt();
            }
            // 煮咖啡的时间 + Min()
        }
    }
}
