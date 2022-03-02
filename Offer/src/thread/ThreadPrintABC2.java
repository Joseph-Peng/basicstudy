package thread;

public class ThreadPrintABC2 {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadPrinter(0)).start();
        new Thread(new ThreadPrinter(1)).start();
        new Thread(new ThreadPrinter(2)).start();
    }

    private static volatile int state = 0;
    private static String name = "ABC";

    static class ThreadPrinter implements Runnable{
        private int type;

        public ThreadPrinter(int type) {
            this.type = type;
        }

        @Override
        public void run() {
            int i = 0;
            while (i<10){
                if (state%3 == type){
                    System.out.println(name.charAt(type));
                    state++;
                    i++;
                }
            }
        }
    }
}
