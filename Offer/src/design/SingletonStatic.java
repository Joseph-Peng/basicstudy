package design;

public class SingletonStatic {
    private static class InstanceHolder{
        private static SingletonStatic instance = new SingletonStatic();
    }

    private SingletonStatic(){}

    public static SingletonStatic getInstance(){
        return InstanceHolder.instance;
    }
}
