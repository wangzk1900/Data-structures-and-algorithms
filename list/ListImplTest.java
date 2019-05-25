package list;

/**
 * 简单测试 ListImpl 中的方法
 */
public class ListImplTest
{
    public static void main(String[] args) throws Exception
    {
        ListImpl<String> list = new ListImpl<>();
        System.out.println("isEmpty(): true");
        System.out.println(list.isEmpty());

        System.out.println("getSize(): 0");
        System.out.println(list.getSize());

        System.out.println("append(): [A, B, C]");
        list.append("A");
        list.append("B");
        list.append("C");
        System.out.println(list.toString());

        System.out.println("insert(): [A, B, D, C]");
        list.insert("D",3);
        System.out.println(list.toString());

        System.out.println("delete(): D");
        System.out.println(list.delete(3));

        System.out.println("copyList(): [A, B, C]");
        System.out.println(list.copyList().toString());
    }
}
