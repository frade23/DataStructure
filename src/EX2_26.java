import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EX2_26 {
        public static int majorityNumber(ArrayList<Integer> nums) {
            HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
            map.put(nums.get(0), 1);
            for(int i=1;i<nums.size();i++){
                if(map.containsKey(nums.get(i))){
                    map.put(nums.get(i), map.get(nums.get(i))+1);
                }else{
                    map.put(nums.get(i), 1);
                }
            }
            Set<Integer> set=map.keySet();
            Iterator<Integer> it=set.iterator();
            while(it.hasNext()){
                int temp=it.next();
                if(map.get(temp)>nums.size()/2){
                    return temp;
                }
            }
            return 0;
        }


    public static void main(String args[]){
//        int[] arrayC = {};
//        majorityNumber(arrayC);
//        arrayC.add(3);
//        arrayC.add(3);
//        arrayC.add(4);
//        arrayC.add(2);
//        arrayC.add(4);
//        arrayC.add(4);
//        arrayC.add(2);
//        arrayC.add(4);
//        arrayC.add(4);
////        int[] arrayC = {3,3,4,2,4,4,2,4,4};
//        function(arrayC);
//    }
//
//    public static void function(ArrayList<Integer> array) {
//        ArrayList<Integer> arrayB = new ArrayList<>();
////        int[] arrayB = new int[array.length];
//        int j = 0;
//        if (array.size() == 2 || array.size() == 1)
//            System.out.print("最大元：" + array.get(0));
//        if (array.size() / 2 == 0) {
//            for (int i = 0; i < array.size(); i += 2) {
//                if (array.get(i) == array.get(i+1)) {
//                    arrayB.add(array.get(i));
//                }
//            }
//        } else for (int i = 0; i < array.size() - 1; i += 2) {
//            if (array.get(i) == array.get(i+1)) {
//                arrayB.add(array.get(i));
//            }
//            function(arrayB);
//        }
    }
}
