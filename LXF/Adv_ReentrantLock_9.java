import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Adv_ReentrantLock_9 {
    


}

class Counter9 {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) {
        lock.lock();
        try {
            count += n;
        } finally {
            lock.unlock();
        }
    }
}