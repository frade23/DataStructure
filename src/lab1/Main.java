package lab1;

import java.util.Scanner;

public class Main {
    // write your own code to test your implementation
    public static void main(String[] args){
        Term term1 = new Term(8,2);
        Term term2 = new Term(3,3);
        Term term3 = new Term(-4,3);
        Term term4 = new Term(-5,5);
        Term term5 = new Term(-6,2);
        Term term6 = new Term(7,7);
        Term term7 = new Term(4,2);

        term1.setNext(term2);


        Polynomial test1 = new Polynomial(term1);
        test1.addTerm(term3);


        Polynomial test2 = new Polynomial(term5);
        term5.setNext(term6);
        test1.setFirst(term4);
        test1.add(test2);

//        test1.addTerm(term7);

        String str = test1.toString();
    }
}

// example: 4.0x^3+3.2x^2-2.1x^1+1.0x^0
//// example: -12.0x^9-1.0x^7+3.0x^5+10.0x^2+5.0x^0