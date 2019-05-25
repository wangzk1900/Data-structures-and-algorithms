package deque;

/**
 * 基于单链表实现双端队列
 * <p>
 * 缺点：
 * 1、删除队尾的元素时比较麻烦，需要遍历整个链表找到倒数第二个节点。
 * 2、涉及边界问题，需要单独处理
 *
 * @author wangzk
 * @param <E>
 */
public class DequeByList1<E> implements Deque<E>
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
        Node<E> newNode = new Node<>(e, head);
        if (isEmpty())
        {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    @Override
    public void insertLast(E e)
    {
        Node<E> newNode = new Node(e, null);
        if (isEmpty())
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public E removeFirst() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("队列已空！");
        }

        Node<E> oldHead = head;
        // 更新队首节点
        head = oldHead.next;

        if (size == 1)
        {
            tail = null;
        }

        size--;
        return oldHead.item;
    }

    @Override
    public E removeLast() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("队列已空！");
        }

        E e = tail.item;

        if (size == 1)
        {
            head = null;
            tail = null;
        }
        else
        {
            // 找到队尾节点的前驱节点
            Node<E> prevNode = head;
            while (prevNode.next != tail)
            {
                prevNode = prevNode.next;
            }
            //更新队尾节点
            tail = prevNode;
            tail.next = null;
        }
        size--;

        return e;
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
