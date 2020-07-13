package queue;

/**
 * @author zhaopeng
 * @create 2020-05-06 22:36
 */
public interface FatherQueue<T>{
    boolean enQueue(int x);
    Integer deQueue();
    Integer front();
    boolean isEmpty();
}
