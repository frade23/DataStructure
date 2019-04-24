package HW3;

class Node<Object>
{
    Object data;
    Node next;
    Node(){
        this(null,null);
    }
    //等价于Node(){data = null;next = null;}
    Node(Object d){
        this(d,null);
    }
    Node(Object d,Node n){
        this.data = d;
        this.next = n;
    }
}
