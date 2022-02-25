package thread;

import java.util.concurrent.locks.ReentrantLock;

public class TicketDemo {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket,"1号窗口");
        Thread thread2 = new Thread(ticket,"2号窗口");
        Thread thread3 = new Thread(ticket,"3号窗口");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Ticket implements Runnable{

    private static int ticket = 100;

    private final ReentrantLock lock = new ReentrantLock(false);// true

    @Override
    public void run() {
        while (true){
            /*lock.lock();
            try {
                Thread.sleep(10);
                if (ticket>0){
                    System.out.println(Thread.currentThread().getName()+"售出车票，ticket号为："+ticket--);
                }else {
                    break;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }*/

            synchronized (Ticket.class){
                if (ticket>0){
                    try {
                        Thread.sleep(10);
                        System.out.println(Thread.currentThread().getName()+"售出车票，ticket号为："+ticket--);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}