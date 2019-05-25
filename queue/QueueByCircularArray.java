package queue;

/**
 * 基于循环数组实现队列
 * <p>
 * 优点：
 * 出队之后不用移动剩余的元素
 *
 * @param <E>
 * @author wangzk
 */
public class QueueByCircularArray<E> implements Queue<E>
{
    private static final int LENGTH = 1024;
    private int size = 0;
    private E[] ary;
    /**
     * 队首元素的索引
     */
    private int head = 0;
    /**
     * 队尾元素的索引
     */
    private int tail = -1;

    public QueueByCircularArray()
    {
        Object[] objArray = new Object[LENGTH];
        ary = (E[]) objArray;
    }

    @Override
    public int getSize()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public void enqueue(E e) throws Exception
    {
        if (size == LENGTH)
        {
            throw new Exception("队列已满！");
        }
        // 添加队尾元素
        tail = (tail + 1) % LENGTH;
        ary[tail] = e;

        // size 加 1
        size++;
    }

    @Override
    public E dequeue() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("队列已空！");
        }
        E oldHead = ary[head];
        // 更新队首元素的索引
        head = (head + 1) % LENGTH;

        // size 减 1
        size--;

        return oldHead;
    }
}
