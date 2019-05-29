package binarysearchtree;


/**
 * @author wangzk
 */
public class BinarySearchTree2Test
{
    public static void main(String[] args)
    {
        BinarySearchTree2 tree = new BinarySearchTree2();
        tree.insert(13);
        tree.insert(8);
        tree.insert(18);
        tree.insert(6);
        tree.insert(10);
        tree.insert(16);
        tree.insert(20);
        tree.insert(18);
        tree.insert(19);
        System.out.println("printByLevel():");
        tree.printByLevel();

        System.out.println();
        System.out.println("isEmpty(): " + tree.isEmpty());
        System.out.println("getSize(): " + tree.getSize());
        System.out.println("getRoot(): " + tree.getRoot());
        System.out.println("getMax(): " + tree.getMax());
        System.out.println("getMin(): " + tree.getMin());
        System.out.println();

        System.out.println("delete():");
        tree.delete(18);
        tree.printByLevel();

        System.out.println();
        System.out.print("inOrder():");
        tree.inOrder();
    }
}
