package example;

import java.text.SimpleDateFormat;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class LianXiang1 {


    /**
     * 输入第一行包含一个正整数n，表示该员工这一天的打卡记录数量。(1<=n<=50)
     * 接下来有n行，每行首先是一个字符串“in”或“out”，分别表示进入和出去。之后是一个时间表示“xx:yy:zz“，表示一个时刻，精确到秒。
     * 请你输出一个形如”xx:yy:zz”的字符串，表示该员工的工作时长。
     * <p>
     * 6
     * in 00:40:14
     * out 04:48:37    04:08:23
     * in 07:06:20
     * out 09:17:53    02:11:33
     * in 10:14:44
     * out 10:36:29    00:21:45
     * <p>
     * 06:41:41
     *
     * @param args
     */
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Deque<String> inStack = new LinkedList<>();
        long res = 0;
        for (int i = 0; i < n; ++i) {
            String time = sc.nextLine();
            String[] strs = time.split(" ");
            if ("in".equals(strs[0])){
                while (!inStack.isEmpty()){
                    inStack.pop();
                }
                inStack.push(strs[1]);
            }else {
                if(!inStack.isEmpty()){
                    String in = inStack.poll();
                    //System.out.println(in);
                    res += cal(in, strs[1]);
                }
            }
        }
        int h = (int) res/3600;
        res = res%3600;
        int m = (int)res/60;
        int s = (int)res%60;
        if(h<10){
            System.out.print("0"+h+":");
        }else{
            System.out.print(h+":");
        }
        if (m<10){
            System.out.print("0"+m+":");
        }else {
            System.out.print(m+":");
        }
        if(s<10) {
            System.out.print("0" + s);
        }else {
            System.out.print(s);
        }
    }

    public static long cal(String in, String out){
        String[] ins = in.split(":");
        String[] outs = out.split(":");
        long intime  = Integer.parseInt(ins[0])* 3600 + Integer.parseInt(ins[1])*60 + Integer.parseInt(ins[2]);
        long outtime  = Integer.parseInt(outs[0])* 3600 + Integer.parseInt(outs[1])*60 + Integer.parseInt(outs[2]);
        return outtime - intime;
    }
}














