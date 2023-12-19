import java.util.concurrent.atomic.*;

/*
 * Java的java.util.concurrent包除了提供底层锁、并发集合外，还提供了一组原子操作的封装类，它们位于java.util.concurrent.atomic包。

我们以AtomicInteger为例，它提供的主要操作有：

增加值并返回新值：int addAndGet(int delta)
加1后返回新值：int incrementAndGet()
获取当前值：int get()
用CAS方式设置：int compareAndSet(int expect, int update)
Atomic类是通过无锁（lock-free）的方式实现的线程安全（thread-safe）访问。它的主要原理是利用了CAS：Compare and Set。
 * 
*/

public class S15_Atomic {
    
}

class IdGenerator {
    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }
}
