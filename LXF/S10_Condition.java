import java.util.concurrent.locks.*;
import java.util.*;

public class S10_Condition {
    
}

class TaskQueue10 {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } 
        catch (Exception e){

        } finally {
            lock.unlock();
        }
        
        return null;
    }
}
