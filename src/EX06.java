public class EX06 {
    //获取字符并转化为数组
    public static void permute(String str) {
        char[] chars = str.toCharArray();
        permute(chars, 0, chars.length - 1);
    }

    //打印字符
    public static void permute(char[] str, int low, int high) {
        if (low == high){
            StringBuilder cout = new StringBuilder();
            for (int i = 0;i <= high;i++)
                cout.append(str[i]);
            System.out.println(cout);
        } else {
            for (int i = low; i <= high; i++) {
                swap(str, low, i);
                permute(str, low + 1, high);
                swap(str, low, i);
            }
        }
    }
    //交换str[i]与str[j]
    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        permute(str);
    }
}