package queue;


/**
 * 基于普通数组实现队列
 * <p>
 * 缺点：
 * 1、队列容量有限，不好扩展；
 * 2、每次出队之后，都要将其它元素整体前移，效率较低
 *
 * @param <E>
 * @author wangzk
 */
public class QueueByArray<E> implements Queue<E>
{
    private static final int LENGTH = 1024;
    private int size = 0;
    private E[] ary;
    /**
     * 队首元素的索引
     */
    private final int head = 0;
    /**
     * 队尾元素的索引
     */
    private int tail = -1;

    public QueueByArray()
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
        // 队尾添加新元素
        ary[++tail] = e;
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

        // 数组元素整体前移
        for (int i = 0; i < size - 1; i++)
        {
            ary[i] = ary[i + 1];
        }

        // 更新队尾元素的索引
        tail--;

        // size 减 1
        size--;

        // 返回原队尾元素
        return oldHead;
    }
}
