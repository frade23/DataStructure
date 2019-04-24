package lab1;

public class Polynomial {

    Term first;
    // create a polynomial
    public Polynomial(Term firstTerm){
        this.first = firstTerm;
    }
    // get the first term
    public Term getFirst(){
        return this.first;
    }
    // set the first term
    public void setFirst(Term first){
        this.first = first;
    }
    // add a single term to the polynomial
    public void addTerm(Term term){
        Term temp;
        for (temp = this.first; temp != null; temp = temp.getNext()){
            if (temp.getExponent() == first.getExponent()){
                 temp.setCoefficient(temp.getCoefficient() + term.getCoefficient());
                 break;
            }
            else if (temp.getNext() == null){
                temp.setNext(term);
                break;
            }
        }
    }




    // add another polynomial, return the sum
    public Polynomial add(Polynomial another){
        for (Term temp = this.first; temp != null; temp = temp.getNext()){
            if (temp.getNext() == null){
                for (Term temp1 = another.getFirst(); temp1 != null; temp1 = temp1.getNext()){
                    addTerm(temp1);
                }
                break;
            }
        }
        sort();
        return this;
    }

    public void sort(){
        for (Term temp = this.first; temp != null; temp = temp.getNext()){
            for (Term temp1 = temp; temp1 != null; temp1 = temp1.getNext()){
                if (temp.getExponent() < temp1.getExponent()){
                    Term term = new Term(temp.getCoefficient(), temp.getExponent());

                    temp.setCoefficient(temp1.getCoefficient());
                    temp.setExponent(temp1.getExponent());

                    temp1.setCoefficient(term.getCoefficient());
                    temp1.setExponent(term.getExponent());
                }
            }
        }
    }
//     convert to string representation
// example: 4.0x^3+3.2x^2-2.1x^1+1.0x^0
// example: -12.0x^9-1.0x^7+3.0x^5+10.0x^2+5.0x^0
    public String toString(){
        String str = "";
        if (first == null){
            return "";
        }

        for (Term temp = first; temp != null; temp = temp.getNext()) {
            if (temp != first) {
                if (temp.getCoefficient() > 0) {
                    System.out.print("+");
                }
            }
//                System.out.printf("kk");

                str += temp.getCoefficient() + "x^" + temp.getExponent();
                System.out.print(temp.getCoefficient() + "x^" + temp.getExponent());
        }

        return str;
    }

}

