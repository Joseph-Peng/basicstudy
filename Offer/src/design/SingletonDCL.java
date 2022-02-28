package design;

public class SingletonDCL {

    private volatile static SingletonDCL instance = null;

    private SingletonDCL(){}

    public static SingletonDCL getInstance(){
        if (instance == null){
            synchronized (SingletonDCL.class){
                if (instance == null){
                    instance = new SingletonDCL();
                    // 1. 分配内存
                    // 2. 初始化实例
                    // 3. 将引用指向分配的内存地址
                    // 由于指令重排，可能出现  1-->2-->3  或者  1-->3-->2
                    // 如果是1 3 2 的执行顺序，那么当A线程执行了1和3后，instance指向就不等于null了，但是对象还未初始化完成
                    // 此时如果A释放了锁，B就会直接返回instance对象，这样就会导致错误
                }
            }
        }
        return instance;
    }
}
