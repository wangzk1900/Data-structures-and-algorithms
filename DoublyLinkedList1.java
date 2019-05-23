package list;

/**
 * 双向链表
 * <p>
 * 插入节点时，需要考虑链表为空的情况。
 * 删除节点时，需要考虑链表中仅剩一个节点的情况。
 *
 * @param <E>
 * @author Sunmoon
 */
public class DoublyLinkedList1<E>
{
    private int size;
    private Node<E> head;
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
        // 新建一个节点
        Node<E> newNode = new Node<>(null, e, head);

        if (isEmpty())
        {
            tail = newNode;
        }
        else
        {
            // 更新 head 的前驱节点
            head.prev = newNode;
        }
        // 更新 head
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
        // 新建一个节点
        Node<E> newNode = new Node<>(tail, e, null);

        if (isEmpty())
        {
            head = newNode;
        }
        else
        {
            // 更新 tail 的后驱节点
            tail.next = newNode;
        }
        // 更新 tail
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
        if (idx > size || idx < 1)
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
            Node<E> newNode = new Node<>(prevNode, e, prevNode.next);
            // 更新前驱节点和后继节点的指针
            newNode.prev.next = newNode;
            newNode.next.prev = newNode;

            size++;
        }

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
        { throw new Exception("链表已空！"); }

        E removedItem = head.item;
        if (size == 1)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
            head.prev = null;
        }
        size--;
        return removedItem;
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

        E removedItem = tail.item;
        if (size == 1)
        {
            head = null;
            tail = null;
        }
        else
        {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return removedItem;
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
            // 找到被删节点
            Node<E> removedNode = getNode(idx);

            // 更新前驱节点和后继节点的指针
            removedNode.prev.next = removedNode.next;
            removedNode.next.prev = removedNode.prev;

            removed = removedNode.item;
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
        if (isEmpty()) {
            throw new Exception("链表已空！");
        }
        return getNode((size + 1) / 2).item;
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

        Node<E> searchedNode;
        int idxOfSearched;
        if (idx <= (size + 1) / 2)
        {
            // 从链头开始找
            searchedNode = head;
            idxOfSearched = 1;
            while (idxOfSearched < idx)
            {
                searchedNode = searchedNode.next;
                idxOfSearched++;
            }
        }
        else
        {
            // 从链尾开始找
            searchedNode = tail;
            idxOfSearched = size;
            while (idxOfSearched > idx)
            {
                searchedNode = searchedNode.prev;
                idxOfSearched--;
            }
        }

        return searchedNode;
    }

    private static class Node<E>
    {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E e, Node<E> next)
        {
            this.prev = prev;
            this.item = e;
            this.next = next;
        }
    }
}
