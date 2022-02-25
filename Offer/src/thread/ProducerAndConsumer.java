package thread;

import java.util.Random;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        ShareBuffer buffer = new ShareBuffer();
        Thread producer1 = new Thread(new Producer(buffer),"producer1");
        Thread consumer1 = new Thread(new Consumer(buffer),"consumer1");
        Thread consumer2 = new Thread(new Consumer(buffer),"consumer2");

        producer1.start();
        consumer1.start();
        consumer2.start();
    }
}

class ShareBuffer{

    private int product = 0;

    public synchronized void addProduct(){
        if (product >=20){
            try {
                System.out.println("缓冲区已满");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            ++product;
            System.out.println(Thread.currentThread().getName()+"生产了第"+product+"个产品。");
            notifyAll();
        }
    }

    public synchronized void getProduct(){
        if(product<=0){
            try {
                System.out.println("缓冲区为空");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName() + "消费了第" + product + "个产品");
            --product;
            notifyAll();
        }

    }

}

class Producer implements Runnable{

    private ShareBuffer buffer;

    public Producer(ShareBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产");
        while (true){
            try {
                Thread.sleep((int) (Math.random()*500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buffer.addProduct();
        }
    }
}

class Consumer implements Runnable{

    private ShareBuffer buffer;

    public Consumer(ShareBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费");
        while (true){
            try {
                Thread.sleep((int) (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buffer.getProduct();
        }
    }
}