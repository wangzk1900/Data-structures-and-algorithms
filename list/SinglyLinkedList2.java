package list;

/**
 * 单向链表（哨兵模式）
 * <p>
 * 在插入和删除元素时，不用考虑边界问题。
 *
 * @param <E>
 * @author Sunmoon
 */
public class SinglyLinkedList2<E>
{
    private int size;
    /**
     * 指向链头的虚拟节点
     */
    private Node<E> header;
    /**
     * 后接链尾的虚拟节点
     */
    private Node<E> tailer;

    public SinglyLinkedList2()
    {
        size = 0;
        header = new Node<>(null, null);
        tailer = new Node<>(null, null);
        header.next = tailer;
    }

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
        Node<E> head = header.next;
        Node<E> newNode = new Node<>(e, head);
        header.next = newNode;
        size++;
    }

    /**
     * 追加一个元素
     *
     * @param e 待追加元素
     */
    public void addAsTail(E e) throws Exception
    {
        // 新建一个节点
        Node<E> newNode = new Node<>(e, tailer);
        // 找到最后一个节点
        Node<E> tail = getNode(size);
        // 更新 tail 的后继节点
        tail.next = newNode;

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
        if (idx > size || idx < 1)
        {
            throw new Exception("超出链表范围！");
        }
        // 找到插入位置的前驱节点
        Node<E> prevNode = getNode(idx - 1);
        // 创建新节点
        Node<E> newNode = new Node<>(e, prevNode.next);
        // 更新 prevNode 的指针
        prevNode.next = newNode;

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

        // 找到第一个节点
        Node<E> head = header.next;
        // 更新 header 的后继节点
        header.next = head.next;

        size--;
        return head.item;
    }

    /**
     * 删除最后一个元素
     *
     * @return 被删节点
     * @throws Exception 链表已空
     */
    public E removeTail() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("链表已空！");
        }

        // 找到最后一个节点的前驱节点
        Node<E> prevTail = getNode(size - 1);
        // 被删元素
        E removed = prevTail.next.item;
        // 更新 prevTail 的后继节点
        prevTail.next = tailer;

        size--;
        return removed;
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

        // 找到被删节点的前驱节点
        Node<E> prevNode = getNode(idx - 1);
        // 被删元素
        E removed = prevNode.next.item;
        // 更新前驱节点的指针
        prevNode.next = prevNode.next.next;

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

        Node<E> prev = header;
        Node<E> curr = header.next;
        Node<E> temp;
        while (prev != tailer)
        {
            // 暂存 second 的后继节点
            temp = curr.next;
            // 指针反转，将当前节点的指针指向前驱节点
            curr.next = prev;
            // 更新 prev 和 curr
            prev = curr;
            curr = temp;
        }

        // 将 header 和 tailer 互换
        temp = header;
        header = tailer;
        tailer = temp;

        // 置空 tailer 的指针
        tailer.next = null;
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
        if (idx > size || idx < 0)
        {
            throw new Exception("超出链表范围！");
        }

        Node<E> searchedNode = header;
        for (int i = 0; i < idx; i++)
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
