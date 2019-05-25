package deque;

/**
 * 简单测试
 *
 * @author wangzk
 */
public class DequeTest
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Test DequeByList1:");
        DequeByList1 dequeByList1 = new DequeByList1();
        dequeByList1.insertFirst("A");
        dequeByList1.insertLast("B");
        System.out.println(dequeByList1.removeFirst());
        System.out.println(dequeByList1.removeLast());

        System.out.println("Test DequeByList2:");
        DequeByList2 dequeByList2 = new DequeByList2();
        dequeByList2.insertFirst("A");
        dequeByList2.insertLast("B");
        System.out.println(dequeByList2.removeFirst());
        System.out.println(dequeByList2.removeLast());

        System.out.println("Test DequeByList3:");
        DequeByList3 dequeByList3 = new DequeByList3();
        dequeByList3.insertFirst("A");
        dequeByList3.insertLast("B");
        System.out.println(dequeByList3.removeFirst());
        System.out.println(dequeByList3.removeLast());
    }
}
