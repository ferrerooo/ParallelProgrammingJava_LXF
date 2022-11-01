import java.util.concurrent.*;

public class Adv_Future_17 {
    
    public static void main(String[] args) throws Exception{
        // 创建一个固定大小的线程池:
        ExecutorService executor = Executors.newFixedThreadPool(4); 
        // 定义任务:
        Callable<String> task = new Task17();
        // 提交任务并获得Future:
        Future<String> future = executor.submit(task);
        // 从Future获取异步执行返回的结果:
        String result = future.get(); // 可能阻塞
        // 关闭线程池:
        executor.shutdown();
    }

}

class Task17 implements Callable<String> {
    public String call() throws Exception {
        return null; 
    }
}