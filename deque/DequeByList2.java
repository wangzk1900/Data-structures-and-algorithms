package deque;

/**
 * 基于双向链表实现的双端队列。
 * <p>
 * 优点：
 * 同时支持对首末节点的快速删除。
 *
 * @author wangzk
 * @param <E>
 */
public class DequeByList2<E> implements Deque<E>
{
    private int size = 0;
    /**
     * 队首节点
     */
    private Node<E> head;
    /**
     * 队尾节点
     */
    private Node<E> tail;

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
    public void insertFirst(E e)
    {
        // 创建新节点
        Node<E> newNode = new Node<>(null, e, head);

        if (size == 0)
        {
            tail = newNode;
        }
        else
        {
            head.prev = newNode;
        }
        // 更新队首节点
        head = newNode;
        size++;
    }

    @Override
    public void insertLast(E e)
    {
        // 创建新节点
        Node<E> newNode = new Node<>(tail, e, null);

        if (size == 0)
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
        }
        // 更新队尾节点
        tail = newNode;
        size++;
    }

    @Override
    public E removeFirst() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("队列已空！");
        }

        E e = head.item;
        head = head.next;

        if (size == 1)
        {
            tail = null;
        }
        else
        {
            head.prev = null;
        }

        size--;
        return e;
    }

    @Override
    public E removeLast() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("队列已空！");
        }

        E e = tail.item;
        tail = tail.prev;

        if (size == 1)
        {
            head = null;
        }
        else
        {
            tail.next = null;
        }

        size--;
        return e;
    }


    private static class Node<E>
    {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E e, Node<E> next)
        {
            this.item = e;
            this.prev = prev;
            this.next = next;
        }

    }

}
