public class S03_ThreadInterruption {

    public static void main(String[] args) throws InterruptedException {
        
        /*Thread t = new MyThread3();
        t.start();
        Thread.sleep(1); // 暂停1毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
        */

        /*Thread t = new MyThread31();
        t.start();
        Thread.sleep(1000);
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
        */

        HelloThread32 t = new HelloThread32();
        t.start();
        Thread.sleep(1);
        t.running = false; // 标志位置为false

    }
}

class MyThread3 extends Thread {
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " hello!");
        }
    }
}

class MyThread31 extends Thread {
    public void run() {
        Thread hello = new HelloThread31();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        hello.interrupt();
    }
}

class HelloThread31 extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

class HelloThread32 extends Thread {
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}

/*
C# version：https://github.com/ferrerooo/ParallelProgrammingCSharp/blob/main/S1_04CancellingTasks.cs
*/
