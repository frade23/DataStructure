import java.util.Arrays;
import java.util.Random;

//选择问题答案
public class ChoiceProblem {

    public static final Random RANDOM = new Random(47);

    //假设N = 10
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            printResult(createArray(RANDOM.nextInt(100000)));
        }
    }

    //冒泡排序
    public static void sort(int[] values){
        for (int i = 1; i < values.length; i++) {
            for (int j = 0; j < values.length - i; j++) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
    }
    //分批处理
    public static int select(int[] values){
        if (values == null || values.length == 0) {
            throw new NullPointerException("values can't be null.");
        }
        int k = values.length / 2;
        int[] temp = Arrays.copyOf(values, k);
        sort(temp);
        for (int i = k ; i < values.length; i++) {
            if (values[i] < temp[k - 1]) {
                temp[k - 1] = temp[k - 2];
                for (int j = k - 2; j >0; j--) {
                    if (values[i] > temp[j]) {
                        temp[j + 1] = values[i];
                        break;
                    }else {
                        temp[j] = temp[j - 1];
                    }
                }
            }
        }
        return temp[k - 1];
    }
    //创建随即数组
    public static int[] createArray(int length){
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            //给数组添加元素
            values[i] = RANDOM.nextInt(length * 2);
        }
        return values;
    }
    //打印结果
    public static void printResult(int[] values){
        System.out.println("length:" + values.length);
        long start = System.currentTimeMillis();
        System.out.println("result:" + select(values));
        System.out.println("cost:" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("--------------------------------");
    }

}
