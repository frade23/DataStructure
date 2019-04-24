package HW3;

import java.util.*;

public class EX3_6 {
    public static void main(String args[]){
        long a = System.currentTimeMillis();
        Scanner input = new Scanner(System.in);
        int M = 20;
        int N = 10000;
        pass(M, N);
        System.out.print((System.currentTimeMillis() -a)+ "s");
    }

    public static void pass(int m, int n) {
        int i, j, gap, numLeft;
        ArrayList<Integer> L = new ArrayList<>();
        for (i = 1; i <= m; i++)
            L.add(i);
        ListIterator<Integer> iter = L.listIterator();
        Integer item = 0;
        numLeft = m;
        for (i = 0; i < m; i++) {
            gap = n % numLeft;
            if (gap <= numLeft / 2) {
                if (iter.hasNext())
                    item = iter.next();
                for (j = 0; j < gap; j++) {
                    if (!iter.hasNext())
                        iter = L.listIterator();
                    item = iter.next();
                }
            } else {
                for (j = 0; j < numLeft - gap; j++) {
                    if (!iter.hasPrevious())
                        iter = L.listIterator(L.size());
                    item = iter.previous();
                }
            }
            System.out.print("removed " + item + " ");
            iter.remove();
            if (!iter.hasNext())
                iter = L.listIterator();
            System.out.println();
            for (Integer x:L)
                System.out.print(x + " ");
            numLeft--;
        }
    }
}
