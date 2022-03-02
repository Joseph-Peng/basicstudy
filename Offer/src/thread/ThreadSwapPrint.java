package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSwapPrint {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Printer2 printer2 = new Printer2();

        Thread t1 = new Thread(printer);
        Thread t2 = new Thread(printer);

        t1.start();
        t2.start();

        /*Thread t3 = new Thread(printer2);
        Thread t4 = new Thread(printer2);

        t3.start();
        t4.start();*/

    }
}

class Printer implements Runnable{
    private int i = 0;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                notify();
                if (i<100) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ++i;
                    System.out.println(Thread.currentThread().getName()+"---"+i);
                }else {
                    //notifyAll();
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Printer2 implements Runnable{

    private int i = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                condition.signal();
                Thread.sleep(50);
                if (i<100){
                    ++i;
                    System.out.println(Thread.currentThread().getName()+"---"+i);
                }else {
                    break;
                }
                condition.await();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }
    }
}

