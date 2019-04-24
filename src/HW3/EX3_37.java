package HW3;

public class EX3_37 {
    LinkList linkList;

    public void setLinkList(LinkList linkList) {
        this.linkList = linkList;
    }
    public void insert(LinkList p, LinkList x){
        x.setNext(p.getNext());
        //值为null;
        p.setNext(x);
    }

    public void delete(LinkList p){
        p = null;
    }
}
