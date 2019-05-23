package list;

/**
 * 双向链表（哨兵模式）
 *
 * @param <E>
 * @author Sunmoon
 */
public class DoublyLinkedList2<E>
{
    private int size;
    /**
     * 指向第一个元素虚拟节点
     */
    private Node<E> header;
    /**
     * 后接最后一个元素虚拟节点
     */
    private Node<E> tailer;

    public DoublyLinkedList2()
    {
        header = new Node<>(null, null, null);
        tailer = new Node<>(null, null, null);
        header.next = tailer;
        tailer.prev = header;
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
        Node<E> newNode = new Node<>(header, e, head);
        header.next = newNode;
        head.prev = newNode;
        size++;
    }

    /**
     * 追加一个元素
     *
     * @param e 待追加元素
     */
    public void addAsTail(E e)
    {
        Node<E> tail = tailer.prev;
        Node<E> newNode = new Node<>(tail, e, tailer);
        tailer.prev = newNode;
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

        // 找到指定位置上的节点
        Node<E> node = getNode(idx);
        // 创建新的节点
        Node<E> newNode = new Node<>(node.prev, e, node);
        // 更新指针
        node.prev.next = newNode;
        node.prev = newNode;

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

        Node<E> head = header.next;
        Node<E> node = head.next;

        header.next = node;
        node.prev = header;

        size--;
        return head.item;
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
        { throw new Exception("链表已空！"); }

        Node<E> tail = tailer.prev;
        Node<E> node = tail.prev;

        tailer.prev = node;
        node.next = tailer;

        size--;
        return tail.item;
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

        // 找到待删节点
        Node<E> removedNode = getNode(idx);
        // 更新前后节点的指针
        removedNode.prev.next = removedNode.next;
        removedNode.next.prev = removedNode.prev;

        size--;
        return removedNode.item;
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
        if (idx > size || idx < 0)
        {
            throw new Exception("超出链表范围！");
        }

        Node<E> searchedNode;
        if (idx <= size / 2)
        {
            searchedNode = header;
            for (int i = 0; i < idx; i++)
            {
                searchedNode = searchedNode.next;
            }
        }
        else
        {
            searchedNode = tailer;
            for (int i = size + 1; i > idx; i--)
            {
                searchedNode = searchedNode.prev;
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


    public static void main(String[] args) throws Exception
    {
        DoublyLinkedList2 doublyLinkedList2 = new DoublyLinkedList2();
        doublyLinkedList2.addAsHead("c");
        doublyLinkedList2.addAsHead("b");
        doublyLinkedList2.addAsHead("a");
        System.out.println(doublyLinkedList2.getNode(1).item);

    }
}
