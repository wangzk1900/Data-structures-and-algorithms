package deque;

/**
 * 双端队列接口
 *
 * @author wangzk
 */
public interface Deque<E>
{
    /**
     * 获取队列中元素的数量
     * @return 队列中元素的数量
     */
    int getSize();

    /**
     * 判断队列是否已空
     * @return 若队列已空，则返回true，否则返回false
     */
    boolean isEmpty();

    /**
     * 在队列前端插入一个元素
     * @param e 待插入元素
     * @throws Exception 队列已满
     */
    void insertFirst(E e) throws Exception;

    /**
     * 在队列后端插入一个元素
     * @param e 待插入元素
     * @throws Exception 队列已满
     */
    void insertLast(E e) throws Exception;

    /**
     * 在队列前端删除一个元素
     * @return 被删元素
     * @throws Exception 队列已空
     */
    E removeFirst() throws Exception;

    /**
     * 在队列后端删除一个元素
     * @return 被删元素
     * @throws Exception 队列已空
     */
    E removeLast() throws Exception;
}
