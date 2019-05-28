package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 基于 ArrayList 构建完全二叉树
 *
 * @author wangzk
 */
public class BinaryTreeByArrayList<E>
{
    /**
     * 存放二叉树的节点数据
     */
    private ArrayList<E> tree;
    /**
     * 二叉树中元素的数量
     */
    private int size;

    public BinaryTreeByArrayList()
    {
        this.tree = new ArrayList<>();
        // 下标为0的位置不存放数据
        this.tree.add(null);
        this.size = 0;
    }

    public int getSize()
    {
        return tree.size();
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * 获取树的高度
     *
     * @return
     */
    public int getTreeHeight()
    {
        return getNodeHeight(1);
    }

    /**
     * 获取指定位置节点的高度
     *
     * @param idx
     * @return
     */
    private int getNodeHeight(int idx)
    {
        if (idx > size)
        {
            return -1;
        }
        else
        {
            // 左子节点的高度
            int left = getNodeHeight(idx * 2);
            // 右子节点的高度
            int right = getNodeHeight(idx * 2 + 1);
            // 当前节点的高度 = 较高的那个子节点的高度 + 1
            return left >= right ? left + 1 : right + 1;
        }
    }

    /**
     * 插入数据
     *
     * @param data
     */
    public void insert(E data)
    {
        tree.add(size + 1, data);
        size++;
    }

    /**
     * 前序遍历
     */
    public void preOrder()
    {
        preOrder(1);
    }

    /**
     * 前序遍历——先打印指定节点，然后打印它的左子树，最后打印它的右子树
     */
    private void preOrder(int idx)
    {
        // 子节点的索引下标
        int left = 2 * idx;
        int right = left + 1;

        if (idx > size)
        {
            return;
        }
        System.out.print(tree.get(idx));
        preOrder(left);
        preOrder(right);
    }

    /**
     * 中序遍历
     */
    public void inOrder()
    {
        inOrder(1);
    }

    /**
     * 中序遍历——对于指定的节点，先打印它的左子树，然后再打印它本身，最后打印它的右子树
     */
    private void inOrder(int idx)
    {
        int left = 2 * idx;
        int right = left + 1;

        if (idx > size)
        {
            return;
        }
        preOrder(left);
        System.out.print(tree.get(idx));
        preOrder(right);
    }

    /**
     * 后序遍历
     */
    public void postOrder()
    {
        postOrder(1);
    }

    /**
     * 后序遍历——对于指定的节点，先打印它的左子树，然后再打印它的右子树，最后打印它本身
     */
    private void postOrder(int idx)
    {
        int left = 2 * idx;
        int right = left + 1;

        if (idx > size)
        {
            return;
        }
        preOrder(left);
        preOrder(right);
        System.out.print(tree.get(idx));
    }

    /**
     * 按层遍历——从根节点开始，按层从左往右打印节点
     */
    public void levelOrder()
    {
        Queue<Integer> indexes = new LinkedList<>();
        indexes.add(1);

        while (!indexes.isEmpty())
        {
            int idx = indexes.poll();
            if (tree.get(idx) == null)
            {
                continue;
            }
            System.out.print(tree.get(idx));

            int left = idx * 2;
            if (left <= size)
            {
                indexes.offer(left);
            }
            int right = left + 1;
            if (right <= size)
            {
                indexes.offer(right);
            }
        }
    }
}
