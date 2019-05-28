package binarytree;

/**
 * 测试 BinaryTree<E> 中的方法
 *
 *            A         height = 3  level =1
 *          /   \
 *         B     C      height = 2  level =2
 *        / \   / \
 *       D   E F   G    height = 1  level =3
 *      / \
 *     H  null          height = 0  level =4
 *    / \
 * null null            height = -1
 *
 * @author wangzk
 */
public class BinaryTreeTest
{
    public static void main(String[] args) throws Exception
    {
        BinaryTree tree = new BinaryTree();
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");
        tree.insert("E");
        tree.insert("F");
        tree.insert("G");
        tree.insert("H");
        tree.printByLevel();

        System.out.println("getSize(): " + tree.getSize());
        System.out.println("getRoot(): "+tree.getRoot());
        System.out.println("getTreeHeight(): "+tree.getTreeHeight());

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
