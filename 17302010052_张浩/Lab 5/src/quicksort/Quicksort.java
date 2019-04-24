package quicksort;

import java.util.Random;

public class Quicksort {
    private static int CUTOFF = 5;
    private Quicksort() { }

    // Your code here
    static int[] sort(int[] unsorted) {
        return sort(unsorted, 0, unsorted.length - 1);
    }

    private static int[] sort(int[] unsorted, int left, int right){
        if (left + CUTOFF < right){
            int pivot = median3(unsorted, left, right);

            int i = left, j = right - 1;
            for ( ; ; ){
                while (unsorted[++i] < pivot){

                }
                while (unsorted[--j] > pivot){

                }
                if (i < j)
                    swapReferences(unsorted, i, j);
                else
                    break;
            }

            swapReferences(unsorted, i, right-1);

            sort(unsorted, left, i-1);
            sort(unsorted, i + 1, right);
        }
        else
            insertSort(unsorted, left, right);
        return unsorted;
    }

    private static int median3(int [] unsorted, int left, int right){
        int center = (left + right)/2;
        if (unsorted[center] < unsorted[left])
            swapReferences(unsorted, left, center);
        if (unsorted[right] < unsorted[left])
            swapReferences(unsorted, left, right);
        if (unsorted[right] < unsorted[center])
            swapReferences(unsorted, right, center);

        swapReferences(unsorted, center, right - 1);
        return unsorted[right - 1];
    }

    private static void swapReferences(int[] unsorted, int left, int right){
        int temp = unsorted[left];
        unsorted[left] = unsorted[right];
        unsorted[right] = temp;
    }

    private static void insertSort(int[] unsorted, int left, int right){
        if (unsorted == null || unsorted .length == 1)
            return;
        int j;

        for (int p = left; p <= right; p++){
            int temp = unsorted[p];
            for (j = p; j > 0 && temp < unsorted[j -1]; j--)
                unsorted[j] = unsorted[j-1];
            unsorted[j] = temp;
        }
    }
    
    // Your code here
    public static void main(String[] args) {

    	for (CUTOFF = 0; CUTOFF < 31; CUTOFF++){
    	    int[] unsorted = new int[10000];
            int i = 0;
            while (i < unsorted.length) {
                int j = (int)(Math.random() * 100000);
                unsorted[i++] = j;
            }
            long time1 = System.currentTimeMillis();
            sort(unsorted);
            long time2 = System.currentTimeMillis();
            System.out.println("M: " + CUTOFF + " time: " + (time2-time1) + " ms");
        }
    }
}
