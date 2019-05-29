package binarysearchtree;


/**
 * @author wangzk
 */
public class BinarySearchTree1Test
{
    public static void main(String[] args)
    {
        BinarySearchTree1 tree = new BinarySearchTree1();
        tree.insert(33);
        tree.insert(16);
        tree.insert(50);
        tree.insert(13);
        tree.insert(18);
        tree.insert(34);
        tree.insert(58);
        tree.insert(15);
        tree.insert(17);
        tree.insert(25);
        tree.insert(51);
        tree.insert(66);
        tree.insert(19);
        tree.insert(27);
        tree.insert(55);
        tree.insert(55);
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
        tree.delete(13);
        tree.delete(18);
        tree.delete(55);
        tree.printByLevel();

        System.out.println();
        System.out.print("inOrder():");
        tree.inOrder();
    }
}
