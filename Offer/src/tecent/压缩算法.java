package tecent;

import java.util.Scanner;
import java.util.Stack;

public class 压缩算法 {
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        String str = in.nextLine();*/
        String str = "[3|B[4|E]]F";
        Stack<Character> stack = new Stack<>();
        StringBuffer res = new StringBuffer();
        while (str.contains("]")){
            int right = str.indexOf("]");
            int left = str.lastIndexOf("[");
            String temp = str.substring(left+1,right);
            String[] splits = temp.split("\\|");
            String str2 = "";
            int n = Integer.parseInt(splits[0]);
            for(int i = 0; i < n; ++i){
                str2 += splits[1];
            }
            str = str.replace("["+temp+"]",str2);
        }
        System.out.println(str);
    }

}

    /*public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int num =0;
        StringBuffer sb = new StringBuffer("");
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c<='9'&&c>='0'){
                num=10*num + c-'0';
            }else if(c=='|'){
                numStack.push(num);
                num = 0;
            }else if(c<='Z'&&c>='A'){
                sb.append(c);
            }else if(c=='['){
                strStack.push(sb.toString());//暂存供遇到 ] 时合并生成新的子串
                sb=  new StringBuffer("");;
            }else{
                num = numStack.pop();
                StringBuffer tmp = new StringBuffer(strStack.pop());
                while(num>0){
                    tmp.append(sb.toString());
                    num--;
                }
                sb=new StringBuffer(tmp.toString());
            }

        }
        System.out.println(sb.toString());
    }*/
