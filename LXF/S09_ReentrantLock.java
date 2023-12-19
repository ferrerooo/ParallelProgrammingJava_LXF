import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class S09_ReentrantLock {
    


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
