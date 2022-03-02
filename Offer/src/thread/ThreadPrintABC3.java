package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrintABC3 {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadPrinter(0)).start();
        new Thread(new ThreadPrinter(1)).start();
        new Thread(new ThreadPrinter(2)).start();
    }

    private static Lock lock = new ReentrantLock();
    private static int state = 0;
    private static String name = "ABC";

    static class ThreadPrinter implements Runnable {
        private int type;

        public ThreadPrinter(int type) {
            this.type = type;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (state % 3 == type) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+":"+name.charAt(type));
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }

        }
    }
}
