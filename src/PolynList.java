class Node{
    public double coef;//系数
    public int exp;//指数  
    public Node next=null;//下个节点  
    public Node(){
        coef=0;
        exp=0;
    }
    public Node(double coef,int exp){
        this.coef=coef;
        this.exp=exp;
    }
}

//多项式类
public class PolynList {
//    public Node print(Node link1){
//        Node pre=link1;
//    }
    //多项式相加
    public Node add(Node link1, Node link2) {
        Node pre=link1;
        Node qre=link2;
        Node p=pre.next;
        Node q=qre.next;
        Node result=p;
        while(p!=null && q!=null){
            if(p.exp<q.exp){
                pre=p;
                p=p.next;
            }else if(p.exp>q.exp){
                Node temp=q.next;
                pre.next=q;
                q.next=p;
                q=temp;
            }else{
                p.coef=p.coef+q.coef;
                if(p.coef==0){
                    pre.next=p.next;
                    p=pre.next;
                }else{
                    pre=p;
                    p=p.next;
                }
                qre.next=q.next;
                q=qre.next;
            }
        }
        if(q!=null){
            pre.next=q;
        }
        return result;
    }

    //添加数据方法
    public Node insert(Node link,double coef,int exp) {//添加节点
        Node node=new Node(coef,exp);
        if(link==null){
            link.next=node;
        }else{
            Node temp=link;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
        }
        return link;
    }

    // example: 4.0x^3+3.2x^2-2.1x^1+1.0x^0
//// example: -12.0x^9-1.0x^7+3.0x^5+10.0x^2+5.0x^0
    //主方法
    public static void main(String[] args) {
        PolynList ts = new PolynList();
        Node link1=new Node();
        Node link2=new Node();
        //第一个多项式
        ts.insert(link1,4,3);
        ts.insert(link1,3.2,2);
        ts.insert(link1,-2.1,1);
        ts.insert(link1,1,0);
        //第二个多项式
        ts.insert(link2,-12,9);
        ts.insert(link2,-1,7);
        ts.insert(link2,3,5);
        ts.insert(link2,10,2);
        ts.insert(link2,5,0);

        link1 = ts.add(link1, link2);

        while(link1!=null){
            if(link1.exp== 0)
                System.out.print(link1.coef);
            else
                System.out.print(link1.coef+"x^"+link1.exp);
            link1=link1.next;
            if(link1!=null && link1.coef > 0)
                System.out.print("+");
        }
    }
}