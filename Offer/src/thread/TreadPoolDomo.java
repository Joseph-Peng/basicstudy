package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreadPoolDomo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
    }
}
