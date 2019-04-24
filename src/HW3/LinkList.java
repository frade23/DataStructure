package HW3;

public class LinkList {
    private LinkList next, data,head;
    LinkList(){
        this.next = null;
    }

    public LinkList(LinkList next) {
        this.next = next;
    }

    public LinkList getNext(){

        return this.next;
    }

    public void setNext(LinkList next) {
        this.next = next;
    }

    public LinkList getData() {
        return data;
    }

    public void setData(LinkList data) {
        this.data = data;
    }
}
