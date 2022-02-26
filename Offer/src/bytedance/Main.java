package bytedance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i<t; ++i){
            Queue<Integer> queue = new LinkedList<Integer>();
            int n = in.nextInt();
            in.nextLine();
            for(int j = 0 ; j<n ; ++j){
                String input = in.nextLine();
                String[] operates = input.split(" ");
                switch(operates[0]){
                    case "PUSH":
                        queue.offer(Integer.valueOf(operates[1]));
                        break;
                    case "TOP":
                        System.out.println(queue.isEmpty()?-1:queue.peek());
                        break;
                    case "SIZE":
                        System.out.println(queue.size());
                        break;
                    case "POP":
                        if (queue.isEmpty()){
                            System.out.println(-1);
                        }else {
                            queue.poll();
                        }
                        break;
                    case "CLEAR":
                        queue.clear();
                        break;
                }
            }
        }
    }


}