import java.util.concurrent.CompletableFuture;

/*
感觉和Future类似，这个CompletableFuture也是Java设计上的一个补丁，本可以做的更好，就是说不需要引入新的类 进而增加了复杂性。

CompletableFuture可以指定异步处理流程：

thenAccept()处理正常结果；
exceptional()处理异常结果；
thenApplyAsync()用于串行化另一个CompletableFuture；
anyOf()和allOf()用于并行化多个CompletableFuture。

参见C#里的 更加一致的语法设计 https://github.com/ferrerooo/ParallelProgrammingCSharp/blob/main/S1_06WaitingForTasks.cs
*/

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
