package jd;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0;i<t;++i){
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            int[] count = new int[3];
            for(int j = 0; j<s.length();++j){
                if (s.charAt(j) == 'A'){
                    count[0]++;
                }else if(s.charAt(j) == 'B'){
                    count[1]++;
                }else {
                    count[2]++;
                }
            }
            if (count[0] == count[1] && count[1] == count[2]){
                System.out.println(0);
            }else {
                System.out.println(2);
            }
        }
    }
}
