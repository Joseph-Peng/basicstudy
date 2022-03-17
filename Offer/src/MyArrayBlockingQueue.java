import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyArrayBlockingQueue<E> {

    private Object[] table;
    private int capacity;
    private int count;
    private int putIndex;
    private int takeIndex;

    private ReentrantLock lock;
    private Condition full;
    private Condition empty;

    public MyArrayBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.table = new Object[capacity];
        this.lock = new ReentrantLock();
        this.full = lock.newCondition();
        this.empty = lock.newCondition();
    }

    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            while (count == capacity){
                full.await();
            }
            enqueue(e);
        }finally {
            lock.unlock();
        }
    }

    public E get() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                empty.await();
            }
            return dequeue();
        }finally {
            lock.unlock();
        }
    }

    private void enqueue(E e) {
        table[putIndex] = e;
        if (++putIndex == capacity){
            putIndex = 0;
        }
        count++;
        empty.signalAll();
    }

    private E dequeue() {
        E e = (E) table[takeIndex];
        table[takeIndex] = null;
        if (++takeIndex == capacity){
            takeIndex = 0;
        }
        count--;
        full.signalAll();
        return e;
    }
}
