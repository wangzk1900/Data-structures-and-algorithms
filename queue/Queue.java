package queue;

/**
 * 队列--先进先出
 * @author wangzk
 * @param <E>
 */
public interface Queue<E>
{
    /**
     * 获取队列中元素数量
     * @return 队列中元素数量
     */
    int getSize();

    /**
     * 判断队列是否已空
     * @return 若队列已空，则返回true，否则返回false
     */
    boolean isEmpty();

    /**
     * 入队
     * @param e 待入队元素
     * @throws Exception 队列已满
     */
    void enqueue(E e) throws Exception;

    /**
     * 出队
     * @return 被删除的元素
     * @throws Exception 队列已空
     */
    E dequeue() throws Exception;
}
