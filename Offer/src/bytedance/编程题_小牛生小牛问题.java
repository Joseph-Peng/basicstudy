package bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 编程题_小牛生小牛问题 {

    public static void main(String[] args) {
        //输入所要计算的年
        Scanner sc = new Scanner(System.in);
        //测试用 存放每只牛的年龄
        List<Integer> rm = new ArrayList<>();
        //定义一个集合存放牛的数量
        List<Animal> m = new ArrayList<>();
        m.add(new Animal(1));
        //判断查询哪一年的数量
        int n = sc.nextInt();
        for(int i = 1;i<= n;i++){

            for(int j = 0 ;j < m.size();j++){
                Animal animal = m.get(j);
                //看看牛是否可以生育
                if(animal.getAge()>= 3 && animal.getAge()<=7){
                    m.add(new Animal(1));
                }
                //判断牛是否死亡
                if(animal.getAge()==10){
                    m.remove(j);
                }else {
                    //年龄加
                    animal.setAge(animal.getAge() + 1);
                }
            }
            rm.add(m.size());
            //测试用输出当年牛的年龄
//            if(i==n){
//                Iterator it = m.iterator();
//                while (it.hasNext()) {
//                    Animal animal = (Animal)it.next();
//                    System.out.println(animal.getAge()-1);
//                }
//            }
        }

        //输出牛的数量
        System.out.println(m.size());
    }


}
//定义母牛这个类
class Animal{
    private int age;

    public Animal(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

