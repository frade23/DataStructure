package lab2;

public class MyDeque {
    DLNode dlNode;
    int currentSize = 0;
    //create a deque
    MyDeque(DLNode node){
        this.dlNode = node;
        currentSize++;
    }
    //insert a node at the beginning of deque
    public void insertFirst(DLNode node){
        this.dlNode = node;
        currentSize++;
    }
    //remove and return the first node
    public DLNode removeFirst(){
        if (currentSize > 0)
            currentSize--;
        if (this.dlNode != null){
            DLNode temp = this.dlNode;
            dlNode = dlNode.getNext();
            return temp;
        }
        else return null;

    }
    //insert a node at the end of deque
    public void insertLast(DLNode node){
        if (this.dlNode == null){
            this.dlNode = node;
            node.setNext(null);
        }else {
            DLNode temp = this.dlNode;

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
        currentSize++;
    }
    //remove and return the last node
    public DLNode removeLast(){
        if (isEmpty())
            return this.dlNode;

        DLNode temp = this.dlNode;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        DLNode temp1 = temp;

        temp = this.dlNode;
        while (temp.getNext() != null){
            if (temp.getNext().getNext() == null){
                temp.setNext(null);
                break;
            }
            temp = temp.getNext();
        }

        if (currentSize == 1){
            dlNode = null;
        }

        currentSize--;
        return temp1;
    }

    //return first node
    public DLNode first(){
        return this.dlNode;
    }
    //return last node
    public DLNode last(){
        DLNode temp = this.dlNode;
        while (temp.next != null){
            temp = temp.next;
        }
        return temp;
    }
    //return number of nodes
    public int size(){
        return currentSize;
    }
    //judge whether the deque is empty
    public boolean isEmpty(){
        return currentSize == 0;
    }
    //display content of the deque
    public String toString(){
        String str = "";
        if (currentSize < 0)
            return "";
        else {
            for (DLNode temp = this.dlNode; temp != null; temp = temp.next)
                str += temp.getElement();
        }
        return str;
    }
}
