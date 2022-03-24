package thread;

import java.util.concurrent.*;

public class CallableDemo {

    public static final int RETRY_TIME = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        MyCallable mc = new MyCallable();
        FutureTask ft = new FutureTask(mc);
        executor.execute(ft);
        try {
            ft.get(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("超时");
            e.printStackTrace();
        }
        /*for(int i = 0;i<RETRY_TIME;++i){

            FutureTask ft = new FutureTask(mc);
            executor.execute(ft);
            try {
                ft.get(3000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("超时");
                e.printStackTrace();
            }
        }*/
        executor.shutdown();
    }
}

class MyCallable implements Callable<Boolean>{

    public static final int RETRY_TIME = 3;

    @Override
    public Boolean call() throws Exception {
        System.out.println("run");
        Thread.sleep(3500);
        return true;
    }
}