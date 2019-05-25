package list;

/**
 * 线性表接口
 * @param <E>
 */
public interface List<E>
{
    /**
     * 判断List是否为空
     * @return 若List为空，则返回true；否则返回false
     */
    boolean isEmpty();
    /**
     * 获取表中元素的个数
     * @return 元素数量
     */
    int getSize();

    /**
     * 访问第 k 个元素
     * @param k 元素的位置索引，从 1 开始
     * @return k位置上的元素
     */
    E get(int k) throws Exception;

    /**
     * 查找指定元素在表中的位置
     * @param e 待查元素
     * @return 元素的位置索引，若未找到则返回 0
     */
    int getIndex(E e);

    /**
     * 在第 k 个位置插入一个新元素
     * @param e 待插元素
     * @param k 插入位置
     * @throws Exception 超出线性表范围
     */
    void insert(E e, int k) throws Exception;

    /**
     * 追加一个元素
     * @param e 待追加元素
     */
    void append(E e);

    /**
     * 删除第 k 个元素
     * @param k 待删元素的位置索引
     * @return 被删的元素
     * @throws Exception 超出线性表范围
     */
    E delete(int k) throws Exception;

    /**
     * 复制一个线性表
     * @return 复制的新线性表
     */
    List copyList();

}


