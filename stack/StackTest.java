package stack;

/**
 * 简单测试
 *
 * @author wangzk
 */
public class StackTest
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Test StackByArray:");
        Stack stack1 = new StackByArray();
        stack1.push("A");
        stack1.push("B");
        stack1.push("C");
        System.out.print(stack1.pop());
        System.out.print(stack1.pop());
        System.out.println(stack1.pop());

        System.out.println("Test StackByLinkedList:");
        Stack stack2 = new StackByArray();
        stack2.push("A");
        stack2.push("B");
        stack2.push("C");
        System.out.print(stack2.pop());
        System.out.print(stack2.pop());
        System.out.println(stack2.pop());
    }
}
