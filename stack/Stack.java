package stack;

/**
 * @author wangzk
 */
public interface Stack<E>
{
    /**
     * 将元素 e 压入栈顶
     * @param e
     * @throws Exception 栈已满
     */
    void push(E e) throws Exception;

    /**
     * 将栈顶元素删除
     * @return 被删元素
     * @throws Exception 栈已空
     */
    E pop() throws Exception;

    /**
     * 获取栈中元素的数量
     * @return 栈中元素的数量
     */
    int getSize();

    /**
     * 判断栈是否已空
     * @return 若栈已空，则返回 true，否则返回 false
     */
    boolean isEmpty();
}
