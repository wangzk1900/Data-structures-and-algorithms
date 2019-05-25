package deque;

/**
 * 基于双向链表实现双端队列，并使用哨兵模式
 * <p>
 * 优点：
 * 简化了代码逻辑，不需要单独处理边界问题。
 *
 * @author wangzk
 * @param <E>
 */
public class DequeByList3<E> implements Deque<E>
{
    private int size;
    /**
     * 指向队首的节点（哨兵）
     */
    private Node<E> header;
    /**
     * 指向队尾的节点（哨兵）
     */
    private Node<E> tailer;

    /**
     * 构造一个空队列
     */
    public DequeByList3()
    {
        header = new Node<>(null, null, null);
        tailer = new Node<>(null, null, null);
        header.next = tailer;
        tailer.prev = header;
        size = 0;
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
    public void insertFirst(E e)
    {
        Node<E> head = header.next;
        Node<E> newNode = new Node<>(header, e, head);
        header.next = newNode;
        head.prev = newNode;
        size++;
    }

    @Override
    public void insertLast(E e)
    {
        Node<E> tail = tailer.prev;
        Node<E> newNode = new Node<>(tail, e, tailer);
        tail.next = newNode;
        tailer.prev = newNode;
        size++;
    }

    @Override
    public E removeFirst() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("队列已空！");
        }

        Node<E> prevNode = header;
        Node<E> head = header.next;
        Node<E> nextNode = head.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        size--;
        return head.item;
    }

    @Override
    public E removeLast() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("队列已空！");
        }

        Node<E> nextNode = tailer;
        Node<E> tail = tailer.prev;
        Node<E> prevNode = tail.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        size--;
        return tail.item;
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
