package jd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int res = 0;
        int life = b * d;
        while (a > 0 && life>0) {
            res++;
            life -= a;
            if (life <=0) break;
            int k = life / b;
            if (life % b != 0) k++;
            a -= k * c;
        }
        if (a<0 || (a==0 && life >0) ) System.out.println(-1);
        else System.out.println(res);
    }
}