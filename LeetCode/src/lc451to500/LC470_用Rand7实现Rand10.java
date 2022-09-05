package lc451to500;

public class LC470_用Rand7实现Rand10 {

    public int rand10() {
        // (randX()-1)*Y + randY() ==> 可以等概率的随机生成[1,X*Y]范围的随机数
        while (true){
            // 1-49的随机数
            int num = (rand7() - 1) * 7 + rand7();
            // 返回结果，+1是为了解决 40%10为0的情况
            if (num<=40) return num % 10 + 1; // 拒绝采样

            num = (num - 40 - 1) * 7 + rand7(); // rand 63
            if(num <= 60) return num % 10 + 1;

            num = (num - 3 -1) * 7 + rand7(); // rand 21
            if(num <= 20) return num % 10 + 1;
        }
    }
    public int rand7(){
        return 0;
    }
}
