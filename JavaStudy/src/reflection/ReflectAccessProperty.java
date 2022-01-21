package reflection;

import java.lang.reflect.Field;

public class ReflectAccessProperty {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("reflection.Student");
        Object student = clazz.newInstance();

        Field age = clazz.getField("age");
        age.set(student,10);
        System.out.println(age.get(student));
        System.out.println(student);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        //name.set(student,"韩立");
        name.set(null,"韩立");//name为静态变量（类变量），可以传入null
        System.out.println(student);
        System.out.println(name.get(null));
        System.out.println(name.get(student));

    }
}

class Student{
    public int age;
    private static String name;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name = " + name +
                '}';
    }
}
