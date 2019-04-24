package HW3;

public class EX3_11 {
    private Node<Object> head;//声明一个头节点类型引用。这和C语言中的结构体类似。
    private int theSize;

    //空参数的构造函数，用于链表的初始化。
    EX3_11(){init();}
    //c.测试值x是否含于链表
    private boolean contains(Object x)
    {
        Node p = head.next;
        while(p!=null){
            if(x.equals(p.data))
                return true;
            else  p = p.next;
        }
        return false;
    }
    //d.如果值x尚未包含于链表，添加值x到该链表的方法。
    boolean add(Object x)
    {
        if(contains(x))
            return false;
        else
        {
            //创建一个新节点，存储x
            Node<Object> p = new Node<Object>(x);
            p.next = head.next;
            //值为null;
            head.next = p;
            theSize++;
        }
        return true;
    }
    //e.如果值x包含于链表，将x从该链表中删除的方法。
    boolean remove (Object x)
    {
        if(!contains(x))
            return false;
        else
        {
            //节点型变量p引用链表的第一个节点。
            Node p = head.next;
            Node trailer = head;
            while(!p.data.equals(x))
            {
                trailer = p; //trailer节点引用跟踪p节点引用。（类似于C语言中的指针）
                p = p.next; //trailer节点引用始终相邻于p节点引用之后。
            }
            trailer.next = p.next;//删除存储x值的那个节点。
            theSize--;
        }
        return true;
    }
    //a.返回链表大小的方法。
    int size(){
        return theSize;
    }
    //b. 打印链表的方法。
    void print()
    {
        Node p = head.next;
        while(p!=null)
        {
            System.out.println(p.data);
            p = p.next;
        }
        System.out.println();

    }
    //链表的初始化方法。
    private void init()
    {
        theSize = 0;
        head = new Node<Object>();//创建头节点
        head.next = null;//生成一个空链表
    }

}


