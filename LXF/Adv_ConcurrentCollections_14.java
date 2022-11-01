/*
 * 因为BlockingQueue非常有用，所以我们不必自己编写，可以直接使用Java标准库的java.util.concurrent包提供的线程安全的集合：ArrayBlockingQueue。

除了BlockingQueue外，针对List、Map、Set、Deque等，java.util.concurrent包也提供了对应的并发集合类。我们归纳一下：

interface	non-thread-safe	thread-safe
List	ArrayList	CopyOnWriteArrayList
Map	HashMap	ConcurrentHashMap
Set	HashSet / TreeSet	CopyOnWriteArraySet
Queue	ArrayDeque / LinkedList	ArrayBlockingQueue / LinkedBlockingQueue
Deque	ArrayDeque / LinkedList	LinkedBlockingDeque
 * 
*/

/*
 * java.util.Collections工具类还提供了一个旧的线程安全集合转换器，可以这么用：

Map unsafeMap = new HashMap();
Map threadSafeMap = Collections.synchronizedMap(unsafeMap);
但是它实际上是用一个包装类包装了非线程安全的Map，然后对所有读写方法都用synchronized加锁，这样获得的线程安全集合的性能比java.util.concurrent集合要低很多，所以不推荐使用。
 * 
*/

public class Adv_ConcurrentCollections_14 {
    
}
