package jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始！");
        Object result = method.invoke(target, args);
        System.out.println("JDK动态代理，监听结束！");
        return result;
    }

    public Object getJDKProxy(Object targetObject) {
        this.target = targetObject;
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),this);
    }

    public static void main(String[] args) {
        JDKProxy proxy = new JDKProxy();
        UserManager userManager = (UserManager) proxy.getJDKProxy(new UserManagerImpl());
        userManager.addUser("xxx","xxx");
        userManager.delUser("xxx");
    }

}

abstract class Test1{
    abstract void test1();
}

class Test2 extends Test1{

    @Override
    void test1() {

    }
}


interface UserManager {
    //新增用户抽象方法
    void addUser(String userName, String password);

    //删除用户抽象方法
    void delUser(String userName);
}

class UserManagerImpl implements UserManager {

    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用了新增的方法！");
        System.out.println("传入参数为 userName: " + userName + " password: " + password);
    }

    @Override
    public void delUser(String userName) {
        System.out.println("调用了删除的方法！");
        System.out.println("传入参数为 userName: " + userName);
    }
}
