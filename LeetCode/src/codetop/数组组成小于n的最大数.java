package codetop;

import java.util.Arrays;
import java.util.Scanner;

public class 数组组成小于n的最大数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String arrays = sc.nextLine();
        String arr[] = arrays.split(" ");

        String s = String.valueOf(n);
        Arrays.sort(arr);

        boolean flag = false;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i<s.length();++i){
            for(int j = 0; j<arr.length;++j){
                if (flag){
                    res.append(arr[arr.length-1]);
                    break;
                }else if(s.charAt(i) == arr[j].charAt(0)){
                    res.append(arr[j]);
                    break;
                }else if(s.charAt(i) < arr[j].charAt(0)){
                    if (j-1>=0){
                        res.append(arr[j-1]);
                        flag = true;
                        break;
                    }else {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(res.toString());
    }
}
