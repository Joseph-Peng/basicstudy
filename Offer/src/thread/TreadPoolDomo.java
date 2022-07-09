package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TreadPoolDomo {

    public static void main(String[] args) {
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor()
        ExecutorService executor = Executors.newSingleThreadExecutor();
    }
}
