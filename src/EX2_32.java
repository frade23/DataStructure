public class EX2_32 {
    public static void main(String args[]){
        int[] array = {1, 2, 3,4,5,6,7,8,9,10};
        binarySearch(array, 3);
    }

    static void binarySearch(int[] arrayA, int x){
        int low = 0,high = arrayA.length -1;
        int mod = (low + high)/2;
        while(arrayA[mod] != x){
            if (x > arrayA[mod]){
                low = mod + 1;
            } else if (x < arrayA[mod]){
                high = mod - 1;
            }
            mod = (low + high)/2;
        }
        System.out.print(mod);
    }
}
