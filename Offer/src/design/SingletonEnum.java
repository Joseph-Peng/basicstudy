package design;

public enum SingletonEnum {



    INSTANCE;

    public void doSomething(){
        System.out.println("doSomething");
    }

    public static void main(String[] args) {
        SingletonEnum.INSTANCE.doSomething();
    }

}
