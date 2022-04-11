package jd;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger x = sc.nextBigInteger();
        sc.nextLine();
        String path = sc.nextLine();
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        for (int i = 0; i < n; ++i) {
            if (path.charAt(i) == 'U') {
                x = x.divide(two);
            } else if (path.charAt(i) == 'R') {
                x = x.multiply(two);
                x = x.add(one);
            } else {
                x = x.multiply(two);
            }
        }
        System.out.println(x);
    }
}
