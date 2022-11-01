import java.util.concurrent.CompletableFuture;

public class Adv_CompletableFuture_18 {
    
    public static void main(String[] args) throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Adv_CompletableFuture_18::fetchPrice);
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result + ". The thread ID is " + Thread.currentThread().getId());
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            System.out.println("Exception ID " + Thread.currentThread().getName());
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        System.out.println("main come here. ID is " + Thread.currentThread().getName());
        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
            System.out.println("fetchPrice id : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}