package HW4;

public class HW4_1 {
    private static boolean similar(BiTree n1, BiTree n2){
        if((n1==null)&&(n2==null))
            return true;
        else{
            if((n1==null)||(n2==null))
                return false;
            else
                return similar(n1.left,n2.left)&&similar(n1.right,n2.right);
        }
    }

}
