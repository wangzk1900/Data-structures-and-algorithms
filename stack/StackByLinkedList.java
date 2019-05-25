package stack;

/**
 * 基于链表实现的栈
 *
 * @author wangzk
 */
public class StackByLinkedList<E> implements Stack<E>
{
    /**
     * 栈顶节点
     */
    Node<E> top;
    /**
     * 栈中元素数量
     */
    int size = 0;

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
    public void push(E e)
    {
        //创建一个新节点
        Node<E> node = new Node(e, top);
        // 更新栈顶节点
        top = node;
        // size 加 1
        size++;
    }

    @Override
    public E pop() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("栈已空");
        }

        Node<E> oldTop = top;
        // 更新栈顶节点
        top = oldTop.next;
        // size 减 1
        size--;

        return oldTop.item;
    }

    private static class Node<E>
    {
        E item;
        Node<E> next;

        Node(E item, Node<E> next)
        {
            this.item = item;
            this.next = next;
        }
    }
}
