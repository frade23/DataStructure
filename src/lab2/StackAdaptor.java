package lab2;

public class StackAdaptor extends MyStack {
    MyDeque myDeque;
    public StackAdaptor(MyDeque myDeque) {
        this.myDeque = myDeque;
    }

    @Override
    public void push(DLNode node) {
        myDeque.insertLast(node);
    }

    @Override
    public DLNode pop() {
        return myDeque.removeLast();
    }

    @Override
    public DLNode top() {
        return myDeque.last();
    }

    @Override
    public int size() {
        return myDeque.size();
    }

    @Override
    public boolean isEmpty() {
        return myDeque.isEmpty();
    }

    @Override
    public String toString() {
        return myDeque.toString();
    }
}
