package queue;

/**
 * 基于单链表实现的队列
 *
 * @param <E>
 * @author wangzk
 */
public class QueueByLinkedList<E> implements Queue<E>
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
    public void enqueue(E e)
    {
        Node<E> node = new Node(e, null);
        if (isEmpty())
        {
            head = node;
        }
        else
        {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    @Override
    public E dequeue() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("队列已空！");
        }
        Node<E> oldHead = head;
        head = oldHead.next;
        size--;
        return oldHead.item;
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
