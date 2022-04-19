package lc451to500;

public class LC470_用Rand7实现Rand10 {

    public int rand10() {
        // (randX()-1)*Y + randY() ==> 可以等概率的随机生成[1,X*Y]范围的随机数
        while (true){
            int a = rand7();
            int b = rand7();
            int num = (a-1)*7 + b;
            if (num<=40) return num % 10 + 1;

            a = num - 40; // rand 9
            b = rand7();
            num = (a-1)*7 + b; // rand 63
            if(num <= 60) return num % 10 + 1;

            a = num - 60; // rand 3
            b = rand7();
            num = (a-1)*7 + b; // rand 21
            if(num <= 20) return num % 10 + 1;
        }
    }
    public int rand7(){
        return 0;
    }
}
