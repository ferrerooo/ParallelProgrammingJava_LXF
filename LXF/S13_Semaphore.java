import java.util.concurrent.*;

public class S13_Semaphore {
    
}

class AccessLimitControl {
    // 任意时刻仅允许最多3个线程获取许可:
    final Semaphore semaphore = new Semaphore(3);

    public String access() throws Exception {
        // 如果超过了许可数量,其他线程将在此等待:
        semaphore.acquire();
        try {
            // TODO:
            return null;
        } finally {
            semaphore.release();
        }
    }
}
