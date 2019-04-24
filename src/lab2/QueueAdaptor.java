package lab2;

public class QueueAdaptor extends MyQueue {
    MyDeque myDeque;
    public QueueAdaptor(MyDeque myDeque) {
        this.myDeque = myDeque;
    }

    @Override
    public void enqueue(DLNode node) {
        myDeque.insertLast(node);
    }

    @Override
    public DLNode dequeue() {
        return myDeque.removeFirst();
    }

    @Override
    public DLNode front() {
        return myDeque.first();
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
