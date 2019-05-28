package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 构建一个完全二叉树，并实现二叉树的四种遍历方法和获取树高度的方法
 *
 * @author wangzk
 */
public class BinaryTree<E>
{
    public int size;
    private Node<E> root;

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * 获取根节点数据
     *
     * @return
     * @throws Exception
     */
    public E getRoot() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("树已空！");
        }
        return root.data;
    }

    /**
     * 获取树的高度
     *
     * @return
     */
    public int getTreeHeight()
    {
        return getNodeHeight(root);
    }

    /**
     * 获取指定节点的高度
     *
     * @param node
     * @return
     */
    private int getNodeHeight(Node<E> node)
    {
        if (node == null)
        {
            return -1;
        }
        else
        {
            // 左子节点的高度
            int left = getNodeHeight(node.leftChild);
            // 右子节点的高度
            int right = getNodeHeight(node.rightChild);
            // 当前节点的高度 = 较高的那个子节点的高度 + 1
            return left >= right ? left + 1 : right + 1;
        }
    }

    /**
     * 从根节点开始，按层插入新的元素
     *
     * @param data
     */
    public void insert(E data)
    {
        Node<E> newNode = new Node<>(data);
        if (isEmpty())
        {
            root = newNode;
        }
        else
        {
            Queue<Node<E>> levelNodes = new LinkedList<>();
            levelNodes.add(root);

            while (!levelNodes.isEmpty())
            {
                // 取出队列中的节点
                Node<E> node = levelNodes.poll();
                // 子节点为null，则将新数据插入该位置
                if (node.leftChild == null)
                {
                    node.leftChild = newNode;
                    break;
                }
                if (node.rightChild == null)
                {
                    node.rightChild = newNode;
                    break;
                }
                // 子节点不为null，则将两个子节点放到队列中
                levelNodes.offer(node.leftChild);
                levelNodes.offer(node.rightChild);
            }

        }
        size++;
    }

    /**
     * 前序遍历
     */
    public void preOrder()
    {
        preOrder(root);
    }

    /**
     * 前序遍历——先打印指定节点，然后打印它的左子树，最后打印它的右子树
     */
    private void preOrder(Node<E> node)
    {
        if (node == null)
        {
            return;
        }
        System.out.print(node.data);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    /**
     * 中序遍历
     */
    public void inOrder()
    {
        inOrder(root);
    }

    /**
     * 中序遍历——对于指定的节点，先打印它的左子树，然后再打印它本身，最后打印它的右子树
     */
    private void inOrder(Node<E> node)
    {
        if (node == null)
        {
            return;
        }
        inOrder(node.leftChild);
        System.out.print(node.data);
        inOrder(node.rightChild);
    }

    /**
     * 后序遍历
     */
    public void postOrder()
    {
        postOrder(root);
    }

    /**
     * 后序遍历——对于指定的节点，先打印它的左子树，然后再打印它的右子树，最后打印它本身
     */
    private void postOrder(Node<E> node)
    {
        if (node == null)
        {
            return;
        }
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.print(node.data);
    }

    /**
     * 按层遍历——从根节点开始，按层从左往右打印节点
     */
    public void levelOrder()
    {
        Queue<Node<E>> levelNodes = new LinkedList<>();
        levelNodes.add(root);

        while (!levelNodes.isEmpty())
        {
            Node<E> node = levelNodes.poll();
            if (node == null)
            {
                continue;
            }
            System.out.print(node.data);

            levelNodes.offer(node.leftChild);
            levelNodes.offer(node.rightChild);
        }
    }

    /**
     * 分层打印树中的数据
     */
    public void printByLevel()
    {
        Queue<Node> currLevel = new LinkedList<>();
        currLevel.add(root);
        Queue<Node> nextLevel = new LinkedList<>();

        for (int i = 0; i < getTreeHeight() + 1; i++)
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


    private static class Node<E>
    {
        E data;
        Node<E> leftChild;
        Node<E> rightChild;

        Node(E data)
        {
            this.data = data;
        }
    }
}

