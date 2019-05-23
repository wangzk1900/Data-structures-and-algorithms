package list;

public class Test
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("=====Test: singlyLinkedList1=====");
        SinglyLinkedList1 singlyLinkedList1 = new SinglyLinkedList1();
        singlyLinkedList1.addAsHead("A");
        singlyLinkedList1.addAsHead("B");
        singlyLinkedList1.addAsHead("C");
        System.out.print("expected result: CBA, actual result: ");
        System.out.print(singlyLinkedList1.removeHead());
        System.out.print(singlyLinkedList1.removeHead());
        System.out.println(singlyLinkedList1.removeHead());

        singlyLinkedList1 = new SinglyLinkedList1();
        singlyLinkedList1.addAsTail("a");
        singlyLinkedList1.addAsTail("b");
        singlyLinkedList1.addAsTail("c");
        System.out.print("removeTail(), expected result: cba, actual result: ");
        System.out.print(singlyLinkedList1.removeTail());
        System.out.print(singlyLinkedList1.removeTail());
        System.out.println(singlyLinkedList1.removeTail());

        singlyLinkedList1 = new SinglyLinkedList1();
        singlyLinkedList1.addAsTail("a");
        singlyLinkedList1.addAsTail("b");
        singlyLinkedList1.addAsTail("c");
        singlyLinkedList1.addByIdx("1",1);
        singlyLinkedList1.addByIdx("4",4);
        singlyLinkedList1.addByIdx("3", 3);
        System.out.print("addByIdx(), expected result: 1a3b4c, actual result: ");
        System.out.print(singlyLinkedList1.removeHead());
        System.out.print(singlyLinkedList1.removeHead());
        System.out.print(singlyLinkedList1.removeHead());
        System.out.print(singlyLinkedList1.removeHead());
        System.out.print(singlyLinkedList1.removeHead());
        System.out.println(singlyLinkedList1.removeHead());

        singlyLinkedList1 = new SinglyLinkedList1();
        singlyLinkedList1.addAsTail("a");
        singlyLinkedList1.addAsTail("b");
        singlyLinkedList1.addAsTail("c");
        System.out.print("expected result: acb, actual result: ");
        System.out.print(singlyLinkedList1.removeByIdx(1));
        System.out.print(singlyLinkedList1.removeByIdx(2));
        System.out.println(singlyLinkedList1.removeByIdx(1));

        singlyLinkedList1 = new SinglyLinkedList1();
        singlyLinkedList1.addAsTail("a");
        singlyLinkedList1.addAsTail("b");
        singlyLinkedList1.addAsTail("c");
        singlyLinkedList1.addAsTail("d");
        singlyLinkedList1.addAsTail("e");
        singlyLinkedList1.addAsTail("f");
        System.out.print("expected result: c, actual result: ");
        System.out.println(singlyLinkedList1.getMiddle());

        singlyLinkedList1 = new SinglyLinkedList1();
        singlyLinkedList1.addAsTail("a");
        singlyLinkedList1.addAsTail("b");
        singlyLinkedList1.addAsTail("c");
        singlyLinkedList1.reverse();
        System.out.print("reverse(), expected result: cba, actual result: ");
        System.out.print(singlyLinkedList1.removeHead());
        System.out.print(singlyLinkedList1.removeHead());
        System.out.println(singlyLinkedList1.removeHead());

        System.out.println("=====Test: singlyLinkedList2=====");
        SinglyLinkedList2 singlyLinkedList2 = new SinglyLinkedList2();
        singlyLinkedList2.addAsHead("A");
        singlyLinkedList2.addAsHead("B");
        singlyLinkedList2.addAsHead("C");
        System.out.print("expected result: CBA, actual result: ");
        System.out.print(singlyLinkedList2.removeHead());
        System.out.print(singlyLinkedList2.removeHead());
        System.out.println(singlyLinkedList2.removeHead());

        singlyLinkedList2 = new SinglyLinkedList2();
        singlyLinkedList2.addAsTail("a");
        singlyLinkedList2.addAsTail("b");
        singlyLinkedList2.addAsTail("c");
        System.out.print("expected result: cba, actual result: ");
        System.out.print(singlyLinkedList2.removeTail());
        System.out.print(singlyLinkedList2.removeTail());
        System.out.println(singlyLinkedList2.removeTail());

        singlyLinkedList2 = new SinglyLinkedList2();
        singlyLinkedList2.addAsTail("a");
        singlyLinkedList2.addAsTail("b");
        singlyLinkedList2.addAsTail("c");
        singlyLinkedList2.addByIdx("1",1);
        singlyLinkedList2.addByIdx("4",4);
        singlyLinkedList2.addByIdx("3", 3);
        System.out.print("addByIdx(), expected result: 1a3b4c, actual result: ");
        System.out.print(singlyLinkedList2.removeHead());
        System.out.print(singlyLinkedList2.removeHead());
        System.out.print(singlyLinkedList2.removeHead());
        System.out.print(singlyLinkedList2.removeHead());
        System.out.print(singlyLinkedList2.removeHead());
        System.out.println(singlyLinkedList2.removeHead());

        singlyLinkedList2 = new SinglyLinkedList2();
        singlyLinkedList2.addAsTail("a");
        singlyLinkedList2.addAsTail("b");
        singlyLinkedList2.addAsTail("c");
        System.out.print("expected result: acb, actual result: ");
        System.out.print(singlyLinkedList2.removeByIdx(1));
        System.out.print(singlyLinkedList2.removeByIdx(2));
        System.out.println(singlyLinkedList2.removeByIdx(1));

        singlyLinkedList2 = new SinglyLinkedList2();
        singlyLinkedList2.addAsTail("a");
        singlyLinkedList2.addAsTail("b");
        singlyLinkedList2.addAsTail("c");
        singlyLinkedList2.addAsTail("d");
        singlyLinkedList2.addAsTail("e");
        singlyLinkedList2.addAsTail("f");
        System.out.print("expected result: c, actual result: ");
        System.out.println(singlyLinkedList2.getMiddle());

        singlyLinkedList2 = new SinglyLinkedList2();
        singlyLinkedList2.addAsTail("a");
        singlyLinkedList2.addAsTail("b");
        singlyLinkedList2.addAsTail("c");
        singlyLinkedList2.reverse();
        System.out.print("reverse(), expected result: cba, actual result: ");
        System.out.print(singlyLinkedList2.removeHead());
        System.out.print(singlyLinkedList2.removeHead());
        System.out.println(singlyLinkedList2.removeHead());


        System.out.println("=====Test: DoublyLinkedList1=====");
        DoublyLinkedList1 doublyLinkedList1 = new DoublyLinkedList1();
        doublyLinkedList1.addAsHead("A");
        doublyLinkedList1.addAsHead("B");
        doublyLinkedList1.addAsHead("C");
        System.out.print(doublyLinkedList1.removeHead());
        System.out.print(doublyLinkedList1.removeHead());
        System.out.println(doublyLinkedList1.removeHead());

        doublyLinkedList1.addAsTail("a");
        doublyLinkedList1.addAsTail("b");
        doublyLinkedList1.addAsTail("c");
        System.out.print(doublyLinkedList1.removeTail());
        System.out.print(doublyLinkedList1.removeTail());
        System.out.println(doublyLinkedList1.removeTail());

        doublyLinkedList1 = new DoublyLinkedList1();
        doublyLinkedList1.addAsTail("a");
        doublyLinkedList1.addAsTail("b");
        doublyLinkedList1.addAsTail("c");
        doublyLinkedList1.addByIdx("1",1);
        doublyLinkedList1.addByIdx("4",4);
        doublyLinkedList1.addByIdx("3", 3);
        System.out.print("addByIdx(), expected result: 1a3b4c, actual result: ");
        System.out.print(doublyLinkedList1.removeHead());
        System.out.print(doublyLinkedList1.removeHead());
        System.out.print(doublyLinkedList1.removeHead());
        System.out.print(doublyLinkedList1.removeHead());
        System.out.print(doublyLinkedList1.removeHead());
        System.out.println(doublyLinkedList1.removeHead());

        doublyLinkedList1 = new DoublyLinkedList1();
        doublyLinkedList1.addAsTail("a");
        doublyLinkedList1.addAsTail("b");
        doublyLinkedList1.addAsTail("c");
        System.out.print("removeByIdx(), expected result: acb, actual result: ");
        System.out.print(doublyLinkedList1.removeByIdx(1));
        System.out.print(doublyLinkedList1.removeByIdx(2));
        System.out.println(doublyLinkedList1.removeByIdx(1));

        doublyLinkedList1 = new DoublyLinkedList1();
        doublyLinkedList1.addAsTail("a");
        doublyLinkedList1.addAsTail("b");
        doublyLinkedList1.addAsTail("c");
        doublyLinkedList1.addAsTail("d");
        doublyLinkedList1.addAsTail("e");
        doublyLinkedList1.addAsTail("f");
        System.out.print("getMiddle(), expected result: c, actual result: ");
        System.out.println(doublyLinkedList1.getMiddle());

        System.out.println("=====Test: DoublyLinkedList2=====");
        DoublyLinkedList2 doublyLinkedList2 = new DoublyLinkedList2();
        doublyLinkedList2.addAsHead("A");
        doublyLinkedList2.addAsHead("B");
        doublyLinkedList2.addAsHead("C");
        System.out.print(doublyLinkedList2.removeHead());
        System.out.print(doublyLinkedList2.removeHead());
        System.out.println(doublyLinkedList2.removeHead());

        doublyLinkedList2.addAsTail("a");
        doublyLinkedList2.addAsTail("b");
        doublyLinkedList2.addAsTail("c");
        System.out.print(doublyLinkedList2.removeTail());
        System.out.print(doublyLinkedList2.removeTail());
        System.out.println(doublyLinkedList2.removeTail());

        doublyLinkedList2 = new DoublyLinkedList2();
        doublyLinkedList2.addAsTail("a");
        doublyLinkedList2.addAsTail("b");
        doublyLinkedList2.addAsTail("c");
        doublyLinkedList2.addByIdx("1",1);
        doublyLinkedList2.addByIdx("4",4);
        doublyLinkedList2.addByIdx("3", 3);
        System.out.print("addByIdx(), expected result: 1a3b4c, actual result: ");
        System.out.print(doublyLinkedList2.removeHead());
        System.out.print(doublyLinkedList2.removeHead());
        System.out.print(doublyLinkedList2.removeHead());
        System.out.print(doublyLinkedList2.removeHead());
        System.out.print(doublyLinkedList2.removeHead());
        System.out.println(doublyLinkedList2.removeHead());

        doublyLinkedList2 = new DoublyLinkedList2();
        doublyLinkedList2.addAsTail("a");
        doublyLinkedList2.addAsTail("b");
        doublyLinkedList2.addAsTail("c");
        System.out.print("removeByIdx(), expected result: acb, actual result: ");
        System.out.print(doublyLinkedList2.removeByIdx(1));
        System.out.print(doublyLinkedList2.removeByIdx(2));
        System.out.println(doublyLinkedList2.removeByIdx(1));

        doublyLinkedList2 = new DoublyLinkedList2();
        doublyLinkedList2.addAsTail("a");
        doublyLinkedList2.addAsTail("b");
        doublyLinkedList2.addAsTail("c");
        doublyLinkedList2.addAsTail("d");
        doublyLinkedList2.addAsTail("e");
        doublyLinkedList2.addAsTail("f");
        System.out.print("getMiddle(), expected result: c, actual result: ");
        System.out.println(doublyLinkedList2.getMiddle());

        System.out.println("=====Test: CircularList1=====");
        CircularList1 circularList1 = new CircularList1();
        circularList1.addAsHead("A");
        circularList1.addAsHead("B");
        circularList1.addAsHead("C");
        System.out.print(circularList1.removeHead());
        System.out.print(circularList1.removeHead());
        System.out.println(circularList1.removeHead());
        circularList1.addAsTail("a");
        circularList1.addAsTail("b");
        circularList1.addAsTail("c");
        System.out.print(circularList1.removeTail());
        System.out.print(circularList1.removeTail());
        System.out.println(circularList1.removeTail());

        System.out.println("=====Test: CircularList2=====");
        CircularList2 circularList2 = new CircularList2();
        circularList2.addAsHead("A");
        circularList2.addAsHead("B");
        circularList2.addAsHead("C");
        System.out.print(circularList2.removeHead());
        System.out.print(circularList2.removeHead());
        System.out.println(circularList2.removeHead());
        circularList2.addAsTail("a");
        circularList2.addAsTail("b");
        circularList2.addAsTail("c");
        System.out.print(circularList2.removeTail());
        System.out.print(circularList2.removeTail());
        System.out.println(circularList2.removeTail());
    }
}
