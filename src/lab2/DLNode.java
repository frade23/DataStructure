package lab2;

public class DLNode {
    int element;
    DLNode prev, next;
    // create a DLNode
    DLNode(int element){
        this.element = element;
    }
    // get the value of the element
    public int getElement(){
        return this.element;
    }
    // set the value of the element
    public void setElement(int element){
        this.element = element;
    }
    // get the previous DLNode
    public DLNode getPrev(){
        return this.prev;
    }
    // set the previous DLNode
    public void setPrev(DLNode prev){
        this.prev = prev;
    }
    // get the next DLNode
    public DLNode getNext(){
        return this.next;
    }
    // set the next DLNode
    public void setNext(DLNode next){
        this.next = next;
    }
}
