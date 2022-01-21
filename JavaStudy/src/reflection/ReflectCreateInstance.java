package reflection;

import java.lang.reflect.Constructor;

public class ReflectCreateInstance {

    public static void main(String[] args) throws Exception {
        System.out.println("1.使用Class.forName(‘类的全路径’)得到对象");
        Class clazz = Class.forName("reflection.User");
        Object o = clazz.newInstance();
        System.out.println(o);

        System.out.println("=============================");
        System.out.println("2.通过public无参构造器创建实例");
        Constructor constructor = clazz.getConstructor();
        Object o1 = constructor.newInstance();
        System.out.println(o1);

        System.out.println("=============================");
        System.out.println("3.通过public有参构造器创建实例");
        Constructor constructor2 = clazz.getConstructor(String.class, int.class);
        Object o3 = constructor2.newInstance("南宫婉", 2001);
        System.out.println(o3);

        System.out.println("=============================");
        System.out.println("4.通过private有参构造器创建实例");
        Constructor privateConstructor = clazz.getDeclaredConstructor(int.class, String.class);
        privateConstructor.setAccessible(true);
        Object o4 = privateConstructor.newInstance(123456, "历飞羽");
        System.out.println(o4);


    }
}

class User{
    private int ID = 123456;
    public String name = "韩立";
    public int age = 2000;

    public User() {
    }

    private User(int ID,String name) {
        this.ID = ID;
        this.name = name;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
