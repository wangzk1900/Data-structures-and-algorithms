package list;

/**
 * 基于双向链表的 List ADT 实现
 *
 * @param <E>
 */
public class ListImpl<E> implements List<E>
{
    private int size;
    /**
     * 指向头节点
     */
    private Node<E> header;
    /**
     * 后接尾节点
     */
    private Node<E> tailer;

    public ListImpl()
    {
        size = 0;
        header = new Node<>(null, null, null);
        tailer = new Node<>(null, null, null);
        header.next = tailer;
        tailer.prev = header;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public int getSize()
    {
        return size;
    }

    @Override
    public E get(int k) throws Exception
    {
        return getNode(k).item;
    }

    @Override
    public int getIndex(E e)
    {
        int idx = 0;
        Node<E> currNode = header;
        while (true)
        {
            currNode = currNode.next;
            idx++;
            if (currNode.item == e)
            {
                break;
            }
        }
        return idx;
    }

    @Override
    public void insert(E e, int k) throws Exception
    {
        // 找到第 k 位置上的节点
        Node<E> node = getNode(k);
        // 创建一个新的节点
        Node<E> newNode = new Node<>(node.prev, e, node);
        // 更新前驱节点和后继节点的指针
        node.prev.next = newNode;
        node.prev = newNode;
        // size 加 1
        size++;
    }

    @Override
    public void append(E e)
    {
        // 创建一个新节点
        Node<E> newNode = new Node<>(tailer.prev,e,tailer);
        // 更新前驱节点和后继节点的指针
        newNode.prev.next=newNode;
        newNode.next.prev=newNode;
        // size 加 1
        size++;
    }

    @Override
    public E delete(int k) throws Exception
    {
        // 找到待删节点
        Node<E> node = getNode(k);
        // 更新前驱节点和后继节点的指针
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // size 减 1
        size--;

        return node.item;
    }

    @Override
    public List copyList()
    {
        // 创建一个新 List
        ListImpl<E> list = new ListImpl<>();
        // 一次将元素添加到新的 List
        Node<E> currNode = header;
        for (int i = 0; i<size;i++)
        {
            currNode = currNode.next;
            list.append(currNode.item);
        }
        return list;
    }

    /**
     * 获取第 k 位置上的节点
     *
     * @param k 节点所在位置，k可以是0，若k=0则返回header
     * @return k位置上的节点
     */
    private Node<E> getNode(int k) throws Exception
    {
        if (k > size || k < 0)
        {
            throw new Exception("k 超出了线性表范围！");
        }

        Node<E> searchedNode;

        // 若 k 在列表的前半部分，则从头开始找
        if (k <= (size + 1) / 2)
        {
            searchedNode = header;
            for (int i = 0; i < k; i++)
            {
                searchedNode = searchedNode.next;
            }
        }
        else
        {
            searchedNode = tailer;
            for (int i = size + 1; i > k; i--)
            {
                searchedNode = searchedNode.prev;
            }
        }
        return searchedNode;
    }

    @Override
    public String toString()
    {
        String listStr = "[";
        Node<E> currNode = header;
        for (int i=0;i<size-1;i++)
        {
            currNode = currNode.next;
            listStr = listStr + currNode.item + ", ";
        }
        listStr = listStr + tailer.prev.item + "]";
        return listStr;
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
