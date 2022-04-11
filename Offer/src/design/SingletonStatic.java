package design;

public class SingletonStatic {
    int x;
    private static class InstanceHolder{
        private static SingletonStatic instance = new SingletonStatic();
        /*void show(){
            System.out.println(SingletonStatic.this.x);
        }*/
    }

    private SingletonStatic(){}

    public static SingletonStatic getInstance(){
        return InstanceHolder.instance;
    }
}
