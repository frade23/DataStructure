package lab3;

import java.nio.BufferUnderflowException;

public class BinaryHeap {
    private int capacity;
    private int[] items;
    private int currentSize;
    private static final int DEFAULT_CAPACITY = 15;

    public BinaryHeap(){   //构造函数1，声明默认大小。
        this(DEFAULT_CAPACITY);
    }
    //create a BinaryHeap
    BinaryHeap(int capacity){
        currentSize = 0;
        items = new int[capacity + 1];
    }

    public BinaryHeap(int[] items){
        currentSize = items.length;
        this.items =  new int[(currentSize+2)*11/10]; //初始化数组。

        int i = 1;
        for(int item:items)  //第一步，将对象全部放入数组。
            this.items[i++] = item;
        buildHeap(); //针对放入数组的所有对象，建堆。

    }
    //insert a element into the heap
    void insert(int x){
        if (currentSize == items.length -1)
            enlarge(items.length*2 + 1);

        int hole = ++currentSize;
        for (items[0] = x; x < items[hole/2]; hole /=2){
            items[hole] = items[hole/2];
        }
        items[hole] = x;
    }
    //return the minimum element
    private int findMin() throws EmptyException{
        if (isEmpty())
            throw new EmptyException();
        return items[1];
    }
    //remove and return the minimum element
    int deleteMin() throws EmptyException{
        if (isEmpty())
            throw new EmptyException();

        int minItem = findMin();
        items[1] = items[currentSize--];
        percolateDown(1);

        return minItem;
    }
    //judge whether the heap is empty
    private boolean isEmpty(){
        return currentSize==0;
    }
    //remove all elements
    public void makeEmpty() throws EmptyException {
        currentSize = 0;
    }

    private void enlarge(int length){
        int[] newItems = new int[length];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
    }

    private void percolateDown(int hole){
        int left;
        int temp = items[hole];

        for (; hole * 2 <= currentSize; hole = left){
            left = hole*2;
            if (left != currentSize && items[left+1] < items[left])
                left++;
            if (items[left] < temp)
                items[hole] = items[left];
            else
                break;
        }
        items[hole] = temp;
    }

    private void buildHeap(){  //建堆。
        for(int i = currentSize/2; i>0; i--)
            //从最后一个儿子开始倒着往前下溯
            percolateDown(i);
    }
}