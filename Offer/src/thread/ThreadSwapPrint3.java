package thread;

public class ThreadSwapPrint3 {

    public static void main(String[] args) {

        PrintNumber printNumber = new PrintNumber();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 1; i<=100; i+=2){
                    printNumber.printNumber(i);
                }
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 2; i<=100; i+=2){
                    printNumber.printNumber(i);
                }
            }
        }).start();
    }
}

class PrintNumber{

    public synchronized void printNumber(int i){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            notify();
            System.out.println(Thread.currentThread().getName()+"---"+i);
            if (i<100)
                wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}