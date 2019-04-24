package HW3;

public class EX3_25 {
    private int[] data;//用于支持push和pop操作的数组
    private int[] minData;//用于支持findMin操作的数组，存储一个最小值序列
    private int dataIndex;//data数组的下标索引
    private int minIndex;//minData数组的下标索引
    private int min;//最小值
    private int size;//元素的个数
    //在构造函数中进行初始化
    private EX3_25(int length){
        data=new int[length];
        minData=new int[length];
        dataIndex=-1;
        minIndex=-1;
        min=0;
        size=0;
    }
    //判断数组是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //入栈
    private void push(int x){
        size++;
        data[++dataIndex]=x;
    }
    //出栈,最小值发生改变
    public int pop(){
        size--;
        return data[dataIndex--];
    }
    //找出数据结构中的最小值
    private int findMin(){
        return sort(data);
    }

    private int delete(){
        for (int i = index(data, findMin()); i < size - findMin(); i++){
            data[i] = data[i+1];
        }
        size--;
        return findMin();
    }

    public int sort(int[] array){
        int min = array[0];
        for (int i = 0; i < size; i++){
            if (array[i] <= min)
                min = array[i];
        }
        return min;
    }

    public int index(int[] array, int x){
        for (int i = 0; i < size; i++){
            if (array[i] == x)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        EX3_25 myStack1=new EX3_25(10);
        int[] a={2,-4,-5,4,-100,7,-2,-9,-3};
        for (int i = 0; i <a.length; i++) {
            myStack1.push(a[i]);
        }
        System.out.println(myStack1.findMin());
        for (int j = 0; j <5; j++) {
            myStack1.pop();
        }
        System.out.println(myStack1.findMin());
    }
}


