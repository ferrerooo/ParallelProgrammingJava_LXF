public class NewThreadCreation_1 {
    
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start(); // 启动新线程

        Thread t2 = new Thread(new MyRunnable());
        t2.start(); // 启动新线程

        Thread t3 = new Thread(() -> {
            System.out.println("start new thread! 3");
        });
        t3.setPriority(10);
        t3.start(); // 启动新线程
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }

}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread 2!");
    }
}

