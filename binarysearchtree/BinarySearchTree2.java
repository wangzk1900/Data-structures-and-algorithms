package binarysearchtree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 支持插入重复数据的二叉查找树
 * <p>
 * 若插入的数据与现有节点的值相同，则将其按大于这个节点的值来处理
 *
 * @author wangzk
 */
public class BinarySearchTree2
{
    private int size;
    private Node root;

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int getRoot()
    {
        return root.data;
    }

    private int getNodeHeight(Node node)
    {
        if (node == null)
        {
            return -1;
        }
        else
        {
            int left = getNodeHeight(node.leftChild);
            int right = getNodeHeight(node.rightChild);
            return left > right ? left + 1 : right + 1;
        }
    }

    /**
     * 查找指定的节点
     *
     * @param data
     * @return
     */
    private Node find(int data)
    {
        Node node = root;
        while (node != null)
        {
            if (data < node.data)
            {
                node = node.leftChild;
            }
            else if (data > node.data)
            {
                node = node.rightChild;
            }
            else
            {
                return node;
            }
        }
        return null;
    }

    /**
     * 获取最小数据
     *
     * @return
     */
    public int getMin()
    {
        Node minNode = root;
        while (minNode.leftChild != null)
        {
            minNode = minNode.leftChild;
        }
        return minNode.data;
    }

    /**
     * 获取最大数据
     *
     * @return
     */
    public int getMax()
    {
        Node maxNode = root;
        while (maxNode.rightChild != null)
        {
            maxNode = maxNode.rightChild;
        }
        return maxNode.data;
    }

    /**
     * 插入数据
     *
     * @param data
     */
    public void insert(int data)
    {
        Node newNode = new Node(data);
        if (isEmpty())
        {
            root = newNode;
            size++;
        }
        else
        {
            Node node = root;
            while (true)
            {
                // 向左查找插入位置
                if (data < node.data)
                {
                    if (node.leftChild == null)
                    {
                        node.leftChild = newNode;
                        size++;
                        return;
                    }
                    else
                    {
                        node = node.leftChild;
                    }
                }
                // 向右查找插入位置
                else
                {
                    if (node.rightChild == null)
                    {
                        node.rightChild = newNode;
                        size++;
                        return;
                    }
                    else
                    {
                        node = node.rightChild;
                    }
                }
            }
        }
    }

    /**
     * 删除数据
     * <p>
     * 分三种情况：
     * 1. 被删节点没有子节点，只需将其父节点中指向该节点的指针置空（root节点需另外处理）；
     * 2. 被删节点有一个子节点，只需将其父节点指向该节点的指针改为指向其子节点；
     * 3. 被删节点有两个子节点，首先需要找出其右子树中最小的节点，然后把这个最小节点放到被删节点的位置上。
     *
     * @param data
     */
    public void delete(int data)
    {
        // 存放待删节点及其父节点
        Deque<Node> stack = new ArrayDeque<>();
        // 待删节点
        Node delNode = root;
        // 待删节点的父节点
        Node pNode = null;
        // 找出所有的待删节点
        while (true)
        {
            while (delNode != null && delNode.data != data)
            {
                pNode = delNode;

                if (data < delNode.data)
                {
                    delNode = delNode.leftChild;
                }
                else if (data > delNode.data)
                {
                    delNode = delNode.rightChild;
                }
            }
            // 没找到，结束循环查找
            if (delNode == null)
            {
                break;
            }
            // 将找到的待删节点及其父节点放到栈中
            stack.push(pNode);
            stack.push(delNode);
            // 更新 delNode 和 pNode，继续查找
            delNode = delNode.rightChild;
            pNode = delNode;
        }

        // 一个也没找到
        if (stack.isEmpty())
        {
            return;
        }

        // 依次删除待删节点
        while (!stack.isEmpty())
        {
            delNode = stack.pop();
            pNode = stack.pop();
            // 1. 待删节点有两个子节点
            if (delNode.leftChild != null && delNode.rightChild != null)
            {
                // 右子树中的最小节点
                Node minNode = delNode.rightChild;
                // 最小节点的父节点
                Node minPNode = delNode;
                // 找出右子树中的最小节点
                while (minNode.leftChild != null)
                {
                    minPNode = minNode;
                    minNode = minNode.leftChild;
                }
                // 最小节点的数据放到被删节点中
                delNode.data = minNode.data;
                // 更新被删节点，及其父节点
                pNode = minPNode;
                delNode = minNode;
            }
            // 2. 待删节点没有子节点或者只有一个子节点
            Node cNode = delNode.leftChild != null ? delNode.leftChild : delNode.rightChild;
            // 被删节点是 root 节点
            if (pNode == null)
            {
                root = cNode;
            }
            // 更新父节点的指针
            else if (pNode.leftChild == delNode)
            {
                pNode.leftChild = cNode;
            }
            else
            {
                pNode.rightChild = cNode;
            }
            size--;
        }
    }

    /**
     * 中序遍历
     * 输出的数据是有序的（升序）
     */
    public void inOrder()
    {
        inOrder(root);
    }

    private void inOrder(Node node)
    {
        if (node == null)
        {
            return;
        }
        inOrder(node.leftChild);
        System.out.print(node.data + ",");
        inOrder(node.rightChild);
    }

    /**
     * 分层打印树中的数据
     */
    public void printByLevel()
    {
        Queue<Node> currLevel = new LinkedList<>();
        currLevel.add(root);
        Queue<Node> nextLevel = new LinkedList<>();

        for (int i = 0; i < getNodeHeight(root) + 1; i++)
        {
            while (!currLevel.isEmpty())
            {
                Node node = currLevel.poll();
                if (node == null)
                {
                    continue;
                }
                System.out.print(node.data + ", ");

                nextLevel.offer(node.leftChild);
                nextLevel.offer(node.rightChild);
            }
            System.out.println();
            Queue<Node> temp = currLevel;
            currLevel = nextLevel;
            nextLevel = temp;
        }
    }

    private static class Node
    {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data)
        {
            this.data = data;
        }
    }
}
