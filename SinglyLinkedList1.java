package list;

/**
 * 单向链表
 * <p>
 * 在插入和删除元素时，涉及到边界时需要特殊处理。
 *
 * @param <E>
 */
public class SinglyLinkedList1<E>
{
    private int size = 0;
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
     * 前插一个元素
     *
     * @param e 待插元素
     */
    public void addAsHead(E e)
    {
        Node<E> newNode = new Node<>(e, head);
        if (isEmpty())
        {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    /**
     * 追加一个元素
     *
     * @param e 待追加元素
     */
    public void addAsTail(E e)
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

    /**
     * 在指定的位置插入新元素
     *
     * @param e   待插元素
     * @param idx 待插入位置
     */
    public void addByIdx(E e, int idx) throws Exception
    {
        if (idx > size)
        {
            throw new Exception("超出链表范围！");
        }

        if (idx == 1)
        {
            addAsHead(e);
        }
        else
        {
            // 找到插入位置的前驱节点
            Node<E> prevNode = getNode(idx - 1);
            // 创建新节点
            Node<E> newNode = new Node<>(e, prevNode.next);
            // 更新 prevNode 的指针
            prevNode.next = newNode;
        }

        size++;
    }

    /**
     * 删除第一个元素
     *
     * @return 被删元素
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
        }

        size--;
        return oldHead.item;
    }

    /**
     * 删除最后一个元素
     *
     * @return 被删元素
     * @throws Exception 链表已空
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
            Node<E> prevTail = getNode(size - 1);
            // 将 prevTail 的后驱节点置空
            prevTail.next = null;
            // 更新 tail
            tail = prevTail;
        }

        size--;
        return oldTail.item;
    }

    /**
     * 删除指定位置的元素
     *
     * @param idx 待删元素的索引
     * @return 被删元素
     */
    public E removeByIdx(int idx) throws Exception
    {
        if (idx > size || idx < 1)
        {
            throw new Exception("超出链表范围！");
        }

        E removed;
        if (idx == 1)
        {
            removed = removeHead();
        }
        else if (idx == size)
        {
            removed = removeTail();
        }
        else
        {
            // 找到待删节点的前驱节点
            Node<E> prevNode = getNode(idx - 1);
            // 更新前驱节点的指针
            prevNode.next = prevNode.next.next;
            // 获取被删元素
            removed = prevNode.next.item;
            size--;
        }

        return removed;
    }

    /**
     * 获取链表中间位置的元素
     *
     * @return 链表中间位置上的元素
     * @throws Exception 链表已空
     */
    public E getMiddle() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("链表已空！");
        }
        return getNode((size + 1) / 2).item;
    }

    /**
     * 链表反转
     *
     * @throws Exception 链表已空
     */
    public void reverse() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("链表已空！");
        }

        Node<E> prev = head;
        Node<E> curr = head.next;
        Node<E> temp;
        while (prev != tail)
        {
            // 暂存 curr 的后继节点
            temp = curr.next;
            // 指针反转，将当前节点的指针指向前驱节点
            curr.next = prev;
            // 更新 prev 和 curr
            prev = curr;
            curr = temp;
        }

        // 头尾节点互换
        temp = head;
        head = tail;
        tail = temp;

        // 置空尾节点的指针
        tail.next = null;
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
