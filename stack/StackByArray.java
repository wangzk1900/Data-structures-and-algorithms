package stack;

/**
 * 基于数组实现的容量固定的栈
 *
 * @author wangzk
 */
public class StackByArray<E> implements Stack<E>
{
    /**
     * 数组的默认长度
     */
    private static final int LENGTH = 1024;
    /**
     * 存放栈元素的数组
     */
    private E[] ary;
    /**
     * 栈顶元素的索引
     */
    private int top = -1;

    public StackByArray()
    {
        Object[] objAry = new Object[LENGTH];
        ary = (E[]) objAry;
    }

    @Override
    public int getSize()
    {
        return top + 1;
    }

    @Override
    public boolean isEmpty()
    {
        return top < 0;
    }

    @Override
    public void push(E e) throws Exception
    {
        if (getSize() == LENGTH)
        {
            throw new Exception("栈已满！");
        }
        ary[++top] = e;
    }

    @Override
    public E pop() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("栈已空！");
        }
        return ary[top--];
    }

}
