package binarytree;

/**
 * 测试 BinaryTreeByArrayList<E> 中的方法
 * @author wangzk
 */
public class BinaryTreeByArrayListTest
{
    public static void main(String[] args)
    {
        BinaryTreeByArrayList<String> tree = new BinaryTreeByArrayList<>();

        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");
        tree.insert("E");
        tree.insert("F");
        tree.insert("G");
        tree.insert("H");


        System.out.println(tree.getSize());
        System.out.println(tree.isEmpty());
        System.out.println("getTreeHeight(): " + tree.getTreeHeight());

        System.out.print("preOrder(): ");
        tree.preOrder();
        System.out.println();

        System.out.print("inOrder(): ");
        tree.inOrder();
        System.out.println();

        System.out.print("postOrder(): ");
        tree.postOrder();
        System.out.println();

        System.out.print("levelOrder(): ");
        tree.levelOrder();
    }

}
