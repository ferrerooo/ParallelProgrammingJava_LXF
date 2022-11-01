public class ThreadSync_5_1 {
    public static void main(String[] args) throws Exception {
        var add = new AddThread51();
        var dec = new DecThread51();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter51.count);
    }
}

class Counter51 {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread51 extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter51.lock) {
                Counter51.count += 1;
            }
        }
    }
}

class DecThread51 extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter51.lock) {
                Counter51.count -= 1;
            }
        }
    }
}
