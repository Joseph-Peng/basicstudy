package thread;

public class ThreadSwapPrint2 {

    public static volatile int flag = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (i<=100){
                    if (flag==0){
                        System.out.println(Thread.currentThread().getName()+" : "+i);
                        i+=2;
                        flag = 1;
                    }
                }
            }
        },"Thread-0").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 2;
                while (i<=100){
                    if (flag==1){
                        System.out.println(Thread.currentThread().getName()+" : "+i);
                        i+=2;
                        flag = 0;
                    }
                }
            }
        },"Thread-1").start();
    }
}


