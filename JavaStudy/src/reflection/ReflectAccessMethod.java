package reflection;

import java.lang.reflect.Method;

public class ReflectAccessMethod {

    public static void main(String[] args) throws Exception{
        Class bossClass = Class.forName("reflection.Boss");

        Object boss = bossClass.newInstance();

        Method hi = bossClass.getDeclaredMethod("hi", String.class);
        hi.invoke(boss,"ha ha!!!");

        Method say = bossClass.getDeclaredMethod("say", int.class, String.class);
        say.setAccessible(true);
        String res1 = (String) say.invoke(boss,100000,"韩立");
        String res2 = (String) say.invoke(null,100000,"韩立1");
        System.out.println(res1);
        System.out.println(res2);
    }
}

class Boss{
    private int sal;
    private String name;

    public void hi(String content){
        System.out.println(content);
    }

    private static String say(int sal, String name){
        return sal+name;
    }
}
