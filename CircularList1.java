package list;

/**
 * 单向循环链表
 *
 * @param <E>
 * @author Sunmoon
 */
public class CircularList1<E>
{
    private int size;
    /**
     * 头节点
     */
    private Node<E> head;
    /**
     * 尾节点
     */
    private Node<E> tail;

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * 插入新元素，作为第一个元素
     *
     * @param e 待插入元素
     */
    public void addAsHead(E e)
    {
        Node<E> newNode = new Node<>(e, head);
        head = newNode;
        if (isEmpty())
        {
            tail = newNode;
        }

        // 更新尾节点的后驱节点
        tail.next = head;

        size++;
    }

    /**
     * 插入新元素，作为最后一个元素
     *
     * @param e 待插入元素
     */
    public void addAsTail(E e)
    {
        Node<E> newNode = new Node<>(e, head);
        if (isEmpty())
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
        }

        // 更新尾节点及其后驱节点
        tail = newNode;
        tail.next = head;
        size++;
    }

    /**
     * 删除第一个元素
     *
     * @return 被删的元素
     * @throws Exception 链表已空
     */
    public E removeHead() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("链表已空！");
        }

        Node<E> oldHead = head;
        if (size == 1)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = oldHead.next;
            tail.next = head;
        }

        size--;
        return oldHead.item;
    }

    /**
     * 删除最后一个元素
     *
     * @return 被删的元素
     * @throws Exception  链表已空
     */
    public E removeTail() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("链表已空！");
        }

        Node<E> oldTail = tail;
        if (size == 1)
        {
            head = null;
            tail = null;
        }
        else
        {
            // 找到最后一个节点的前驱节点
            Node<E> prevTail = getNode(size-1);
            // 将 prevTail 的后驱节点置空
            prevTail.next = null;
            // 更新 tail
            tail = prevTail;
            tail.next = head;
        }

        size--;
        return oldTail.item;
    }

    /**
     * 获取指定位置的节点
     *
     * @param idx 指定位置的索引
     * @return 指定位置节点
     * @throws Exception 超出链表范围
     */
    public Node<E> getNode(int idx) throws Exception
    {
        if (idx > size || idx < 1)
        {
            throw new Exception("超出链表范围！");
        }

        Node<E> searchedNode = head;
        for (int i = 0; i < idx - 1; i++)
        {
            searchedNode = searchedNode.next;
        }
        return searchedNode;
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
