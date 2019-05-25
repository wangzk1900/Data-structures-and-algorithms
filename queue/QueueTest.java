package queue;

/**
 * 简单测试
 *
 * @author wangzk
 */
public class QueueTest
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Test QueueByArray:");
        Queue queue1 = new QueueByArray();
        queue1.enqueue("A");
        queue1.enqueue("B");
        queue1.enqueue("C");
        System.out.print(queue1.dequeue());
        System.out.print(queue1.dequeue());
        System.out.println(queue1.dequeue());

        System.out.println("Test QueueByCircularArray:");
        Queue queue2 = new QueueByCircularArray();
        queue2.enqueue("A");
        queue2.enqueue("B");
        queue2.enqueue("C");
        System.out.print(queue2.dequeue());
        System.out.print(queue2.dequeue());
        System.out.println(queue2.dequeue());

        System.out.println("Test QueueByLinkedList:");
        Queue queue3 = new QueueByLinkedList();
        queue3.enqueue("A");
        queue3.enqueue("B");
        queue3.enqueue("C");
        System.out.print(queue3.dequeue());
        System.out.print(queue3.dequeue());
        System.out.println(queue3.dequeue());

    }
}
