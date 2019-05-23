package list;

/**
 * 双向循环链表
 *
 * @author Sunmoon
 * @param <E>
 */
public class CircularList2<E>
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
        // 新建一个节点
        Node<E> newNode = new Node<>(null, e, head);
        Node<E> oldHead = head;

        if (isEmpty())
        {
            tail = newNode;
        }
        else
        {
            // 更新 oldHead 的前驱节点
            oldHead.prev = newNode;
        }
        // 更新 head
        head = newNode;

        // 更新 head 前驱节点和 tail 的后继节点
        head.prev = tail;
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
        // 新建一个节点
        Node<E> newNode = new Node<>(tail, e, null);
        Node<E> oldTail = tail;

        if (isEmpty())
        {
            head = newNode;
        }
        else
        {
            // 更新 oldTail 的后驱节点
            oldTail.next = newNode;
        }
        // 更新 tail
        tail = newNode;

        // 更新 head 前驱节点和 tail 的后继节点
        head.prev = tail;
        tail.next = head;

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

        E removedItem = head.item;
        if (size == 1)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
            head.prev = tail;
            tail.next = head;
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
            tail.next = head;
            head.prev = tail;
        }

        size--;
        return removedItem;
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
